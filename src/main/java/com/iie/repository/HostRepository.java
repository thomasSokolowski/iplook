/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.repository;

import com.iie.model.Host;
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
public interface HostRepository extends JpaRepository<Host, Long> {

    @Query("SELECT h FROM Host h WHERE h.date between :dateTime and (Select max(hos.date) from Host hos)")
    List<Host> findByDate(@Param("dateTime")DateTime dateTime);

    @Query("Select max(h.date) from Host h")
    DateTime findMaxDateForHost();

    @Query("Select h from Host h where h.date < :dateTime")
    List<Host>listAllRecordsOlderThanDate(@Param("dateTime")DateTime dateTime);

    @Modifying
    @Transactional
    @Query("Delete from Host h where h.date < :dateTime")
    void dropOlderThan(@Param("dateTime")DateTime dateTime);
}
