/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.converter;

import com.iie.dto.IpDto;
import com.iie.model.Ip;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dev
 */
@Component
@Transactional
public class IpConverter {

    public IpDto convertToDto(Ip ip) {
        ModelMapper mapper = new ModelMapper();
        IpDto ipDto = mapper.map(ip, IpDto.class);
        return ipDto;
    }

    public Ip convertToEntity(IpDto ipDto) {
        ModelMapper mapper = new ModelMapper();
        Ip ip = mapper.map(ipDto, Ip.class);
        return ip;
    }
}
