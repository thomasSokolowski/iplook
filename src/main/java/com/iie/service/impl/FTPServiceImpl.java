package com.iie.service.impl;

import com.iie.service.FileTransferService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by dev on 12/6/2014.
 */
@Service
public class FTPServiceImpl implements FileTransferService {

    private static Logger LOG = Logger.getLogger(FTPServiceImpl.class);
    @Value("${ftp.url}")
    private String ftpUrl;

    @Value("${ftp.username}")
    private String ftpUsername;

    @Value("${ftp_password}")
    private String ftpPassword;

    @Value("${ftp.port}")
    private int ftpPort;


    @Override
    public void uploadFile(File file) {
        FTPClient ftpClient = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            ftpClient = createFtpClient();
            LOG.info("Path to file: " + file.getAbsolutePath());

            ftpClient.storeFile(file.getName(), fileInputStream);
        } catch (IOException e) {
            LOG.error("There was an error during uploading file to FTP: ", e);
        } finally {
            IOUtils.closeQuietly(fileInputStream);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                LOG.error("Exception caught during disconnecting from ftp {}", e);
            }
            LOG.info("Upload has been accomplished");
        }

    }

    private FTPClient createFtpClient() throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(ftpUrl);
        ftpClient.setDefaultPort(ftpPort);
        ftpClient.enterLocalPassiveMode();
        ftpClient.login(ftpUsername, ftpPassword);
        LOG.info("Created ftp client with url " + ftpUrl + " and username " + ftpUsername);

        return ftpClient;
    }

    @Override
    public void downloadFile() {

    }
}
