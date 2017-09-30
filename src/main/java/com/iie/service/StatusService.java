/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iie.service;

import com.iie.dto.ApplicationDto;
import com.iie.dto.HostDto;
import com.iie.dto.IpDto;
import com.iie.model.Application;
import com.iie.model.Ip;
import com.iie.model.Status;
import java.util.List;

/**
 *
 * @author dev
 */
public interface StatusService {
    Status listAllOfInfo(IpDto ip, List<ApplicationDto> listOfApp);
    Status listAppIpHosts(IpDto ip, List<ApplicationDto> listOfApp, List<HostDto> listOfHosts);
}
