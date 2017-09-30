/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.service;

import com.iie.dto.ApplicationDto;
import com.iie.model.Application;
import java.util.List;

import com.iie.model.enums.AppName;
import org.joda.time.DateTime;

/**
 *
 * @author dev
 */
public interface ApplicationService extends CommonService{

    Application create(ApplicationDto applicationDto);

    void delete(Long applicationId);

    List<ApplicationDto> findAll();

    ApplicationDto findById(Long id);

    ApplicationDto findOutTheNewestStatus(String appName);

    List<ApplicationDto> findAppsByDate();


    boolean isArrived(DateTime dateTime, AppName appName);
}
