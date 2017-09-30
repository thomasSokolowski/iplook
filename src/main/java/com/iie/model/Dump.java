package com.iie.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by dev on 8/4/2014.
 */
@Entity
@Table(name="DUMP")
public class Dump {

    @Id
    @GeneratedValue
    @Column(name="DUMP_ID")
    private Long id;

    @Column(name="DUMP_NAME")
    private String dumpName;

    @Column(name="DUMP_DATE")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dumpDate;

    @Column( name = "DUMP_FILE" )
    @Lob
    private byte[] dumpFile;

    public Dump() {
    }


    public Dump(String dumpName, DateTime dumpDate, byte[] dumpFile) {
        this.dumpName = dumpName;
        this.dumpDate = dumpDate;
        this.dumpFile = dumpFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDumpName() {
        return dumpName;
    }

    public void setDumpName(String dumpName) {
        this.dumpName = dumpName;
    }

    public DateTime getDumpDate() {
        return dumpDate;
    }

    public void setDumpDate(DateTime dumpDate) {
        this.dumpDate = dumpDate;
    }

    public byte[] getDumpFile() {
        return dumpFile;
    }

    public void setDumpFile(byte[] dumpFile) {
        this.dumpFile = dumpFile;
    }
}
