/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.service.impl;

import com.iie.converter.HostConverter;
import com.iie.dto.HostDto;
import com.iie.model.Host;
import com.iie.repository.HostRepository;
import com.iie.service.HostService;
import com.iie.utils.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dev
 */
@Service
public class HostServiceImpl implements HostService {
    private static Logger LOG = Logger.getLogger(HostServiceImpl.class);
    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private HostConverter hostConverter;

    @Autowired
    private DateUtils dateUtils;

    @Override
    public Host create(HostDto hostDto) {
        return hostRepository.save(hostConverter.convertToEntity(hostDto));
    }

    @Override
    public void delete(Long hostId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HostDto> findAll() {
        List<HostDto> hostDtos = new ArrayList<>();
        List<Host> hosts = hostRepository.findAll();
        for (Host host : hosts) {
            hostDtos.add(hostConverter.convertToDto(host));
        }
        return hostDtos;
    }

    @Override
    public HostDto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DateTime findMaxDate() {
        return hostRepository.findMaxDateForHost();
    }

    @Override
    public List<HostDto> listWhoDoWeHaveOnline() {

        List<HostDto> hostDtos = new ArrayList<>();
        DateTime dateTime = hostRepository.findMaxDateForHost().minusMinutes(5);
        List<Host> hosts = hostRepository.findByDate(dateTime);
        for (Host host : hosts) {
            hostDtos.add(hostConverter.convertToDto(host));
        }
        return hostDtos;
    }

    @Override
    public boolean isArrived(DateTime dateTime) {
        LOG.info("Current date: " + dateTime);
        return dateUtils.isDateInRage(
                dateTime.toDateTime(DateTimeZone.UTC).minusMinutes(30),
                dateTime.toDateTime(DateTimeZone.UTC),
                findMaxDate().toDateTime(DateTimeZone.UTC));

    }

    @Override
    public List<HostDto> listAllRecordsOlderThanDate(DateTime dateTime) {
        List<HostDto> hostDtos = new ArrayList<>();
        List<Host> hosts = hostRepository.listAllRecordsOlderThanDate(dateTime);
        for (Host host : hosts) {
            hostDtos.add(hostConverter.convertToDto(host));
        }
        return hostDtos;
    }

    @Override
    public void dropOlderThanDate(DateTime dateTime) {
         hostRepository.dropOlderThan(dateTime);
    }
}
