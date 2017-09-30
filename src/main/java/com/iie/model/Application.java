package com.iie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dev
 */
@Entity
public class Application {
    @Id
    @GeneratedValue
    @Column(name="APPLICATION_ID")
    private Long id;
    @Column(name = "APPLICATION_NAME")
    private String applicationName;
    @Column(name="IS_ALIVE")
    private boolean alive;
    @Column(name="DATE_OF_INSERTION")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime date;

    public Application(Long id, String applicationName, boolean alive, DateTime date) {
        this.id = id;
        this.applicationName = applicationName;
        this.alive = alive;
        this.date = date;
    }

    public Application(String applicationName, boolean alive, DateTime date) {
        this.applicationName = applicationName;
        this.alive = alive;
        this.date = date;
    }

       
    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Application() {
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "Application{" + "applicationName=" + applicationName + ", alive=" + alive + '}';
    }
    
    
}
