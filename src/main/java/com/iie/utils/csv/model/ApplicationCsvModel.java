package com.iie.utils.csv.model;

import org.joda.time.DateTime;
import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

/**
 * Created by dev on 8/2/2014.
 */
@CsvDataType()
public class ApplicationCsvModel {
    @CsvField(pos=1)
    public Long id;
    @CsvField(pos=2)
    private String applicationName;
    @CsvField(pos=3)
    private boolean alive;
    @CsvField(pos=4)
    private String date;

    public ApplicationCsvModel() {
    }

    public ApplicationCsvModel(Long id, String applicationName, boolean alive, String date) {
        this.id = id;
        this.applicationName = applicationName;
        this.alive = alive;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
