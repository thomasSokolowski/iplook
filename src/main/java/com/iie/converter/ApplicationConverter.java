/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iie.converter;

import com.iie.dto.ApplicationDto;
import com.iie.model.Application;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dev
 */
@Component
@Transactional
public class ApplicationConverter {
   
    public ApplicationDto convertToDto(Application application) {
        ModelMapper mapper = new ModelMapper();
        ApplicationDto applicationDto  = mapper.map(application, ApplicationDto.class);
        return applicationDto;
    }

    public Application convertToEntity(ApplicationDto applicationDto) {
        ModelMapper mapper = new ModelMapper();
        Application application = mapper.map(applicationDto, Application.class);
        return application;
    }  
}
