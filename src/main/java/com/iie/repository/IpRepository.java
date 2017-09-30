/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.repository;

import com.iie.model.Ip;
import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dev
 */
@Repository
public interface IpRepository extends JpaRepository<Ip, Long> {

    @Query("SELECT i FROM Ip i where i.date=(select max(p.date) from Ip p)")
    public Ip findTheNewestIp();

    @Query("Select i from Ip i where i.date < :dateTime")
    List<Ip> listAllRecordsOlderThanDate(@Param("dateTime")DateTime dateTime);

    @Modifying
    @Transactional
    @Query("Delete from Ip i where i.date < :dateTime")
    void dropOlderThan(@Param("dateTime")DateTime dateTime);
}
