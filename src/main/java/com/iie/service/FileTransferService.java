package com.iie.service;

import java.io.File;

/**
 * Created by dev on 12/6/2014.
 */
public interface FileTransferService {

    void uploadFile(File file);
    void downloadFile();
}
