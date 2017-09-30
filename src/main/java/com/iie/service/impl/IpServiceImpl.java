/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.service.impl;

import com.iie.converter.IpConverter;
import com.iie.dto.HostDto;
import com.iie.dto.IpDto;
import com.iie.model.Host;
import com.iie.model.Ip;
import com.iie.repository.IpRepository;
import com.iie.service.IpService;
import com.iie.utils.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dev
 */
@Service
public class IpServiceImpl implements IpService {

    //    private static final String TIMEZONE = "Europe/Warsaw";
    @Autowired
    private IpRepository ipRepository;
    @Autowired
    private IpConverter ipConverter;
    @Autowired
    private DateUtils dateUtils;
    private static Logger LOG = Logger.getLogger(
            IpServiceImpl.class);

    @Override
    public Ip create(IpDto ipDto) {
        Ip ip = ipRepository.save(ipConverter.convertToEntity(ipDto));
        return ip;
    }

    @Override
    public void delete(Long ipId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IpDto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IpDto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IpDto findTheNewestIp() {
        return ipConverter.convertToDto(ipRepository.findTheNewestIp());
    }

    @Override
    public boolean isArrived(DateTime dateTime) {
        LOG.info("Current date: "+ dateTime);
        return dateUtils.isDateInRage(
                dateTime.toDateTime(DateTimeZone.UTC).minusMinutes(30),
                dateTime.toDateTime(DateTimeZone.UTC),
                findTheNewestIp().getDate().toDateTime(DateTimeZone.UTC));
    }

    @Override
    public List<IpDto> listAllRecordsOlderThanDate(DateTime dateTime) {
        List<IpDto> ipDtos = new ArrayList<>();
        List<Ip> ips = ipRepository.listAllRecordsOlderThanDate(dateTime);
        for (Ip ip : ips) {
            ipDtos.add(ipConverter.convertToDto(ip));
        }
        return ipDtos;
    }

    @Override
    public void dropOlderThanDate(DateTime dateTime) {
        ipRepository.dropOlderThan(dateTime);
    }

}
