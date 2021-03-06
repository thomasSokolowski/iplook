package com.iie.utils.csv.model;

import org.joda.time.DateTime;
import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

/**
 * Created by dev on 8/2/2014.
 */
@CsvDataType()
public class HostCsvModel {
    @CsvField(pos=1)
    private Long id;
    @CsvField(pos=2)
    private String ip;
    @CsvField(pos=3)
    private String hostname;
    @CsvField(pos=4)
    private String date;

    public HostCsvModel() {
    }

    public HostCsvModel(Long id, String ip, String hostname, String date) {
        this.id = id;
        this.ip = ip;
        this.hostname = hostname;
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

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
