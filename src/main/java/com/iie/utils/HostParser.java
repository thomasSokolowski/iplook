/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.utils;

import com.iie.dto.HostDto;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author dev
 */
@Component
public class HostParser {

    public List<HostDto> parseHostCSVToList(String hostsCSV) {
        StringTokenizer stringTokenizer = new StringTokenizer(hostsCSV, ",");
        List<HostDto> listOfHosts = new ArrayList<>();
        while (stringTokenizer.hasMoreElements()) {
            String hostname = stringTokenizer.nextElement().toString();
            String ip = stringTokenizer.nextElement().toString();
            listOfHosts.add(new HostDto(ip,hostname,new DateTime()));
        }
        return listOfHosts;
    }

}
