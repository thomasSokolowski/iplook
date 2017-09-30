/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iie.utils.other;

import com.iie.model.Status;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author dev
 */
class JsonToModelConverter {
       ObjectMapper objectMapper = new ObjectMapper();
       public InputStreamReader fetchFromUrl(String sURL) throws IOException {
        URL url = new URL(sURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        return new InputStreamReader((InputStream) request.getContent());
    }

    public Status readStateOfAllServices(String url){
        Status status = null;
        try {
            status = objectMapper.readValue(fetchFromUrl(url),Status.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }
}
