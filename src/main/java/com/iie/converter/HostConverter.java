/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iie.converter;

import com.iie.dto.HostDto;
import com.iie.model.Host;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dev
 */
@Component
@Transactional
public class HostConverter {
        public HostDto convertToDto(Host host) {
        ModelMapper mapper = new ModelMapper();
        HostDto hostDto = mapper.map(host, HostDto.class);
        return hostDto;
    }

    public Host convertToEntity(HostDto hostDto) {
        ModelMapper mapper = new ModelMapper();
        Host host = mapper.map(hostDto, Host.class);
        return host;
    }
}
