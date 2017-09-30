/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.model;

import com.iie.dto.ApplicationDto;
import com.iie.dto.HostDto;
import com.iie.dto.IpDto;
import java.util.List;

/**
 *
 * @author dev
 */
public class Status {

    private IpDto ip;
    private List<ApplicationDto> applicationList;
    private List<HostDto> hostList;

    public Status(IpDto ip) {
        this.ip = ip;
    }
    
    public Status(IpDto ip, List<ApplicationDto> applicationList) {
        this.ip = ip;
        this.applicationList = applicationList;
    }

    public Status(IpDto ip, List<ApplicationDto> applicationList, List<HostDto> hostList) {
        this.ip = ip;
        this.applicationList = applicationList;
        this.hostList = hostList;
    }
    

    public Status() {
    }

    public IpDto getIp() {
        return ip;
    }

    public void setIp(IpDto ip) {
        this.ip = ip;
    }

    public List<ApplicationDto> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<ApplicationDto> applicationList) {
        this.applicationList = applicationList;
    }

    public List<HostDto> getHostList() {
        return hostList;
    }

    public void setHostList(List<HostDto> hostList) {
        this.hostList = hostList;
    }

    @Override
    public String toString() {
        return "Status{" + "ip=" + ip + ", applicationList=" + applicationList + ", hostList=" + hostList + '}';
    }

   

    
}
