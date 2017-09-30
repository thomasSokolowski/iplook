/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.service.impl;

import com.iie.converter.ApplicationConverter;
import com.iie.converter.IpConverter;
import com.iie.dto.ApplicationDto;
import com.iie.dto.HostDto;
import com.iie.dto.IpDto;
import com.iie.model.Application;
import com.iie.model.Ip;
import com.iie.model.Status;
import com.iie.service.StatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dev
 */
@Service
public class StatusServiceImpl implements StatusService {

    @Override
    public Status listAllOfInfo(IpDto ip, List<ApplicationDto> listOfApp) {
        Status status = new Status();
        status.setIp(ip);
        status.setApplicationList(listOfApp);
        return status;

    }

    @Override
    public Status listAppIpHosts(IpDto ip, List<ApplicationDto> listOfApp, List<HostDto> listOfHosts) {
        Status status = new Status();
        status.setIp(ip);
        status.setApplicationList(listOfApp);
        status.setHostList(listOfHosts);
        return status;

    }

}
