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
public class IpDto {

    private Long id;

    private String ip;

    private DateTime date;

    public IpDto(Long id, String ip, DateTime date) {
        this.id = id;
        this.ip = ip;
        this.date = date;
    }

    public IpDto(String ip) {
        this.ip = ip;
    }

    public IpDto() {
    }

    public IpDto(String ip, DateTime date) {
        this.ip = ip;
        this.date = date;
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

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "IpDto{ ip=" + ip + ", date=" + date + '}';
    }

}
