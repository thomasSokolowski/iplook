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
public class ApplicationDto {

    public Long id;
    private String applicationName;
    private boolean alive;
    private DateTime date;

    public ApplicationDto(Long id, String applicationName, boolean alive, DateTime date) {
        this.id = id;
        this.applicationName = applicationName;
        this.alive = alive;
        this.date = date;
    }


    public ApplicationDto(String applicationName, boolean alive, DateTime date) {
        this.applicationName = applicationName;
        this.alive = alive;
        this.date = date;
    }

    public ApplicationDto(String applicationName, boolean alive) {
        this.applicationName = applicationName;
        this.alive = alive;
    }

    public ApplicationDto() {
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

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }
    

    @Override
    public String toString() {
        return "ApplicationDto{" + "id=" + id + ", applicationName=" + applicationName + ", alive=" + alive + '}';
    }

}
