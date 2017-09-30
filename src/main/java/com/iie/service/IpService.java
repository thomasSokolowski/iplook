/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.service;

import com.iie.dto.IpDto;
import com.iie.model.Ip;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author dev
 */
public interface IpService extends CommonService{

    Ip create(IpDto ipDto);

    void delete(Long ipId);

    List<IpDto> findAll();

    IpDto findById(Long id);

    IpDto findTheNewestIp();
    


}
