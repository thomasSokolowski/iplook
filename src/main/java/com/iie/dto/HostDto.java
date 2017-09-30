/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iie.dto;

import org.joda.time.DateTime;

/**
 *
 * @author dev
 */
public class HostDto {
   private Long id;
   private String ip;
   private String hostname;
   private DateTime date;

    public HostDto(Long id, String ip, String hostname, DateTime date) {
        this.id = id;
        this.ip = ip;
        this.hostname = hostname;
        this.date = date;
    }

    public HostDto(String ip, String hostname, DateTime date) {
        this.ip = ip;
        this.hostname = hostname;
        this.date = date;
    }

    public HostDto(String ip, String hostname) {
        this.ip = ip;
        this.hostname = hostname;
    }

    
    public HostDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HostDto{" + "ip=" + ip + ", hostname=" + hostname + ", date=" + date + '}';
    }
   
   
}
