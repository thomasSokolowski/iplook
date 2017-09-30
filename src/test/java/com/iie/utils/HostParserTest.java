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
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author dev
 */
public class HostParserTest {

    public HostParserTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of parseHostCSVToList method, of class HostParser.
     */
    @Test
    public void testParseHostCSVToList() {
        String testCSV = "Netgear-TomatoUSB,192.168.1.1,dev-PC,192.168.1.12,iie-pc,192.168.1.15,raspberrypi,192.168.1.47";
        StringTokenizer stringTokenizer = new StringTokenizer(testCSV, ",");
        List<HostDto> listOfHosts = new ArrayList<>();
        while (stringTokenizer.hasMoreElements()) {
            String hostname = stringTokenizer.nextElement().toString();
            String ip = stringTokenizer.nextElement().toString();
            HostDto hostDto = new HostDto();
            hostDto.setHostname(hostname);
            hostDto.setIp(ip);
            listOfHosts.add(hostDto);
        }

        System.out.println(listOfHosts);
        assertEquals(4,  listOfHosts.size());
        assertEquals("Netgear-TomatoUSB", listOfHosts.get(0).getHostname());
    }

}
