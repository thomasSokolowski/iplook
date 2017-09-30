package com.iie.utils.other;

import com.iie.model.Status;
import org.junit.Test;

/**
 * Created by dev on 6/27/2014.
 */
public class test {

    private static final String SOURCE_ALL_SERVICES = "http://iplook-iie.rhcloud.com/rest/brands/getThemAll/";
    @Test
    public void testParsing (){
        JsonToModelConverter jsonToModelConverter = new JsonToModelConverter();

        Status status = jsonToModelConverter.readStateOfAllServices(SOURCE_ALL_SERVICES);
        System.out.println(status);
    }
}
