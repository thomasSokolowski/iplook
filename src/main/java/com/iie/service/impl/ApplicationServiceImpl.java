/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.service.impl;

import com.iie.converter.ApplicationConverter;
import com.iie.dto.ApplicationDto;
import com.iie.model.Application;
import com.iie.model.enums.AppName;
import com.iie.repository.ApplicationRepository;
import com.iie.service.ApplicationService;
import java.util.ArrayList;
import java.util.List;

import com.iie.utils.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dev
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationConverter applicationConverter;

    @Autowired
    private DateUtils dateUtils;

    @Override
    public Application create(ApplicationDto applicationDto) {
        return applicationRepository.save(applicationConverter.convertToEntity(applicationDto));
    }

    @Override
    public void delete(Long applicationId) {
        applicationRepository.delete(applicationId);
    }

    @Override
    public List<ApplicationDto> findAll() {
        List<ApplicationDto> applicationDtos = new ArrayList<>();
        List<Application> listOfApplications = applicationRepository.findAll();
        for (Application application : listOfApplications) {
            applicationDtos.add(applicationConverter.convertToDto(application));
        }

        return applicationDtos;
    }

    @Override
    public ApplicationDto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ApplicationDto findOutTheNewestStatus(String appName) {
        return applicationConverter.convertToDto(applicationRepository.findOutTheNewestStatus(appName));
    }

    @Override
    public List<ApplicationDto> findAppsByDate() {
        List<ApplicationDto> applicationDtos = new ArrayList<>();
        DateTime dateTime = applicationRepository.findMaxDate().minusMinutes(5);
        List<Application> listOfApplications = applicationRepository.findByDate(dateTime);
        for (Application application : listOfApplications) {
            applicationDtos.add(applicationConverter.convertToDto(application));
        }

        return applicationDtos;
    }

    @Override
    public boolean isArrived(DateTime dateTime, AppName appName) {
        return dateUtils.isDateInRage(
                dateTime.toDateTime(DateTimeZone.UTC).minusMinutes(30),
                dateTime.toDateTime(DateTimeZone.UTC),
                findOutTheNewestStatus(appName.name()).getDate().toDateTime(DateTimeZone.UTC));
    }

    @Override
    public boolean isArrived(DateTime dateTime) {
        return false;
    }

    @Override
    public List<ApplicationDto> listAllRecordsOlderThanDate(DateTime dateTime) {
        List<ApplicationDto> applicationDtos = new ArrayList<>();
        List<Application> applications = applicationRepository.listAllRecordsOlderThanDate(dateTime);
        for (Application application : applications) {
            applicationDtos.add(applicationConverter.convertToDto(application));
        }
        return applicationDtos;
    }

    @Override
    public void dropOlderThanDate(DateTime dateTime) {
        applicationRepository.dropOlderThan(dateTime);
    }
}
