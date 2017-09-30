/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.service;

import com.iie.dto.HostDto;
import com.iie.model.Host;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author dev
 */
public interface HostService extends CommonService {

    Host create(HostDto hostDto);

    void delete(Long hostId);

    List<HostDto> findAll();

    HostDto findById(Long id);
    
    DateTime findMaxDate();
    
    List<HostDto> listWhoDoWeHaveOnline();
//
//    List<HostDto> listAllRecordsOlderThanDate(DateTime dateTime);
//
//    void dropOlderThanDate(DateTime dateTime);



}
