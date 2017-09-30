/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.service.impl;

import com.iie.dto.ApplicationDto;
import com.iie.dto.HostDto;
import com.iie.dto.IpDto;
import com.iie.model.Dump;
import com.iie.model.enums.AppName;
import com.iie.service.*;
import com.iie.utils.csv.model.ApplicationCsvModel;
import com.iie.utils.csv.model.HostCsvModel;
import com.iie.utils.csv.model.IpCsvModel;
import com.iie.utils.csv.serializator.CsvGenerator;
import com.iie.utils.messages.WarningEmail;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dev
 */
public class SchedulerServiceImpl {

    private static Logger LOG = Logger.getLogger(SchedulerServiceImpl.class);
    @Autowired
    private IpService ipService;

    @Autowired
    private HostService hostService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private MailSender mailSender;

    @Value("${network.exception.message}")
    private String homeNetworkFailure;

    private static final String SOMETHING_IS_WRONG = "Ops, something is not ok at home! ";
    private static final String HURRY_UP = "Hurry up ";
    private static final String DEAD = " is dead!";
    @Autowired
    private CsvGenerator csvGenerator;
    @Autowired
    private DumpService dumpService;

    @Autowired
    private WarningEmail warningEmail;

    @Transactional
    public void checkIfIpHasArrived() {
        LOG.info("Checking ip range time");
        if (!ipService.isArrived(new DateTime())) {
            ipService.create(new IpDto(homeNetworkFailure, new DateTime()));
            mailSender.sendEmail(warningEmail.generateMessage("IP"));
            LOG.info(SOMETHING_IS_WRONG + HURRY_UP);
        }
        LOG.info("We are good to go, time is in the rage so no insertion on IP has been made");
    }

    @Transactional
    public void checkIfHostHasArrived() {
        LOG.info("Checking host range time");
        if (!hostService.isArrived(new DateTime())) {
            hostService.create(new HostDto(homeNetworkFailure, "No h0st", new DateTime()));
            mailSender.sendEmail(warningEmail.generateMessage("Hosts"));
            LOG.info(SOMETHING_IS_WRONG + HURRY_UP);
        }
        LOG.info("We are good to go, time is in the rage so no insertion on Host has been made");
    }

    @Transactional
    public void checkIfAppHasArrived() {
        LOG.info("Checking app range time");
        if (!applicationService.isArrived(new DateTime(), AppName.OPENVPN)) {
            applicationService.create(new ApplicationDto(AppName.OPENVPN.getAppName(), false, new DateTime()));
            mailSender.sendEmail(warningEmail.generateMessage(AppName.OPENVPN.getAppName()));
            LOG.info(SOMETHING_IS_WRONG + HURRY_UP + AppName.OPENVPN + DEAD);
        }
        if (!applicationService.isArrived(new DateTime(), AppName.MINIDLNA)) {
            applicationService.create(new ApplicationDto(AppName.MINIDLNA.getAppName(), false, new DateTime()));
            mailSender.sendEmail(warningEmail.generateMessage(AppName.MINIDLNA.getAppName()));
            LOG.info(SOMETHING_IS_WRONG + HURRY_UP + AppName.MINIDLNA + DEAD);
        }
        if (!applicationService.isArrived(new DateTime(), AppName.XTIGHTVNC)) {
            applicationService.create(new ApplicationDto(AppName.XTIGHTVNC.getAppName(), false, new DateTime()));
            mailSender.sendEmail(warningEmail.generateMessage(AppName.XTIGHTVNC.getAppName()));
            LOG.info(SOMETHING_IS_WRONG + HURRY_UP + AppName.XTIGHTVNC + DEAD);
        }
        if (!applicationService.isArrived(new DateTime(), AppName.TRANSMISSIONGUI)) {
            applicationService.create(new ApplicationDto(AppName.TRANSMISSIONGUI.getAppName(), false, new DateTime()));
            mailSender.sendEmail(warningEmail.generateMessage(AppName.TRANSMISSIONGUI.getAppName()));
            LOG.info(SOMETHING_IS_WRONG + HURRY_UP + AppName.TRANSMISSIONGUI + DEAD);
        }

        LOG.info("We are good to go, time is in the rage so no insertion on Apps has been made. The End");
    }

    @Transactional
    public void createMonthlyDump() {
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            DateTime month = dateTime.minusMonths(1);
            LOG.info("Creating dump");
            List<HostDto> hostDtos = (List<HostDto>) hostService.listAllRecordsOlderThanDate(month);

            if (CollectionUtils.isNotEmpty(hostDtos)) {
                List<HostCsvModel> hostCsvModels = new ArrayList<>();
                for (HostDto host : hostDtos) {
                    hostCsvModels.add(new HostCsvModel(host.getId(), host.getIp(), host.getHostname(), host.getDate().toString()));
                }
                byte[] hostCsvDump = csvGenerator.createCsvDump(HostCsvModel.class, hostCsvModels);
                dumpService.create(new Dump("HostDump", new DateTime(), hostCsvDump));
                LOG.info("Creating dump for Hosts done");
                hostService.dropOlderThanDate(month);
                LOG.info("Old hosts have been dropped");

            }

            List<IpDto> ipDtos = (List<IpDto>) ipService.listAllRecordsOlderThanDate(month);
            if (CollectionUtils.isNotEmpty(ipDtos)) {
                List<IpCsvModel> ipCsvModels = new ArrayList<>();

                for (IpDto ipDto : ipDtos) {
                    ipCsvModels.add(new IpCsvModel(ipDto.getId(), ipDto.getIp(), ipDto.getDate().toString()));
                }

                byte[] ipCsvDump = csvGenerator.createCsvDump(IpCsvModel.class, ipCsvModels);
                dumpService.create(new Dump("IpDump", new DateTime(), ipCsvDump));
                LOG.info("Creating dump for Ips done");
                ipService.dropOlderThanDate(month);
                LOG.info("Old ips have been dropped");
            }

            List<ApplicationDto> applicationDtos = (List<ApplicationDto>) applicationService.listAllRecordsOlderThanDate(month);
            if (CollectionUtils.isNotEmpty(applicationDtos)) {
                List<ApplicationCsvModel> applicationCsvModels = new ArrayList<>();

                for (ApplicationDto applicationDto : applicationDtos) {
                    applicationCsvModels.add(new ApplicationCsvModel(applicationDto.getId(), applicationDto.getApplicationName(), applicationDto.isAlive(), applicationDto.getDate().toString()));
                }
                byte[] applicationCsvDump = csvGenerator.createCsvDump(ApplicationCsvModel.class, applicationCsvModels);
                dumpService.create(new Dump("ApplicationDump", new DateTime(), applicationCsvDump));
                LOG.info("Creating dump for Applications done");
                applicationService.dropOlderThanDate(month);
                LOG.info("Old Apps has been dropped");
            }
        } catch (IOException e) {
            LOG.error("Exception during dumping");
        }
    }
//    @Transactional
//    public void test(){
//        mailSender.sendEmail(warningEmail.generateMessage("Naah just messaing with ya"));
//    }


}
