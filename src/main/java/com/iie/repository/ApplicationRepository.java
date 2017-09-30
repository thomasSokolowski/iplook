/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.repository;

import com.iie.model.Application;
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
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a where a.date=(select max(app.date) from Application app where lower(app.applicationName)=lower(:appName)) and "
            + "lower(a.applicationName)=lower(:appName)")
    public Application findOutTheNewestStatus(@Param("appName") String appName);

    @Query("Select max(a.date) from Application a")
    public DateTime findMaxDate();

    @Query("SELECT a FROM Application a WHERE a.date between :dateTime and (Select max(ap.date) from Application ap)")
    public List<Application> findByDate(@Param("dateTime") DateTime dateTime);

    @Query("Select a from Application a where a.date < :dateTime")
    List<Application> listAllRecordsOlderThanDate(@Param("dateTime")DateTime dateTime);

    @Modifying
    @Transactional
    @Query("Delete from Application a where a.date < :dateTime")
    void dropOlderThan(@Param("dateTime")DateTime dateTime);
}
