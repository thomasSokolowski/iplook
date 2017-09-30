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
import org.hibernate.annotations.Type;

/**
 *
 * @author dev
 */
@Entity
public class Ip {

    @Id
    @GeneratedValue
    private Long id;
    
    private String ip;

    @Column
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime date;

    public Ip(Long id, String ip, DateTime date) {
        this.id = id;
        this.ip = ip;
        this.date = date;
    }

    public Ip() {
    }

    public Ip(String ip) {
        this.ip = ip;
    }

    public Ip(String ip, DateTime date) {
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
        return "IP{" + "id=" + id + ", ip=" + ip + ", date=" + date + '}';
    }

}
