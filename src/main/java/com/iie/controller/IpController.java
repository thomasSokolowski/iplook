package com.iie.controller;

import com.iie.dto.ApplicationDto;
import com.iie.dto.HostDto;
import com.iie.dto.IpDto;
import com.iie.model.Status;
import com.iie.service.*;
import com.iie.utils.HostParser;
import com.iie.utils.csv.serializator.CsvGenerator;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/brands")
public class IpController {
    private static Logger LOG = Logger.getLogger(IpController.class);
    @Autowired
    private IpService ipService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private HostParser hostParser;

    @Autowired
    private HostService hostService;

    @Autowired
    private CsvGenerator csvGenerator;

    @Autowired
    private DumpService dumpService;

    @Autowired
    private FileTransferService fileTransferService;


    @RequestMapping(value = "/readIp/{ip}", method = RequestMethod.POST)
    public
    @ResponseBody
    String readValue(@PathVariable("ip") String ip) {
        ipService.create(new IpDto(ip, new DateTime()));
        return "ip";
    }

    @RequestMapping(value = "/getLatest/", method = RequestMethod.GET)
    public @ResponseBody
    IpDto getLatest() {
        return ipService.findTheNewestIp();
    }

    @RequestMapping(value = "/readApplication/{app}/{alive}", method = RequestMethod.POST)
    public
    @ResponseBody
    String getApplicationStatus(@PathVariable("app") String app, @PathVariable("alive") boolean alive) {
        applicationService.create(new ApplicationDto(app, alive, new DateTime()));
        return app + " is " + alive;
    }

    @RequestMapping(value = "/getTheFreshDataForWww/", method = RequestMethod.GET)
    public
    @ResponseBody
    void getTheFreshDataForWww() {
        LOG.info("Producing json for www");
        Status status = statusService.listAppIpHosts(ipService.findTheNewestIp(), applicationService.findAppsByDate(), hostService.listWhoDoWeHaveOnline());
        File jsonFile = new File("data.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(jsonFile, status);
        } catch (IOException e) {
            LOG.error("Exception caught during serialization of JSON {}", e);
        }
        fileTransferService.uploadFile(jsonFile);
        LOG.info("Creating new JSON file finished!");

    }

    @RequestMapping(value = "/getTheFreshestContent/", method = RequestMethod.GET)
    public
    @ResponseBody
    Status getTheFreshestContent() {
        LOG.info("Getting the freshest Content and time " + ipService.findTheNewestIp().getDate());
        return statusService.listAppIpHosts(ipService.findTheNewestIp(), applicationService.findAppsByDate(), hostService.listWhoDoWeHaveOnline());

    }

    @RequestMapping(value = "/readHosts/{hosts}", method = RequestMethod.POST)
    public
    @ResponseBody
    String getTheHostsList(@PathVariable("hosts") String hosts) {
        List<HostDto> parsedHost = hostParser.parseHostCSVToList(hosts);
        for (HostDto hostDto : parsedHost) {
            hostService.create(hostDto);
        }
        return hosts;
    }

    @RequestMapping(value = "/getHosts/", method = RequestMethod.GET)
    public
    @ResponseBody
    List<HostDto> getHosts() {
        return hostService.listWhoDoWeHaveOnline();
    }

    @RequestMapping(value = "/getApps/", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ApplicationDto> getApplications() {
        return applicationService.findAppsByDate();
    }

    @RequestMapping(value = "/getThemAll/", method = RequestMethod.GET)
    public
    @ResponseBody
    Status getThemAll() {
        return statusService.listAllOfInfo(ipService.findTheNewestIp(), applicationService.findAppsByDate());
    }
}
