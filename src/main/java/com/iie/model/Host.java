/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.model;

import org.joda.time.DateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author dev
 */
@Entity
@Table(name = "HOST")
public class Host {

    @Id
    @GeneratedValue
    @Column(name = "HOST_ID")
    private Long id;
    @Column(name = "HOSTNAME")
    private String hostname;
    @Column(name = "IP")
    private String ip;
    @Column(name = "DATE_OF_SCAN")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime date;

    public Host(Long id, String hostname, String ip, DateTime date) {
        this.id = id;
        this.hostname = hostname;
        this.ip = ip;
        this.date = date;
    }

    public Host(String hostname, String ip, DateTime date) {
        this.hostname = hostname;
        this.ip = ip;
        this.date = date;
    }

    public Host() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
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
        return "Host{" + "hostname=" + hostname + ", ip=" + ip + ", date=" + date + '}';
    }

}
