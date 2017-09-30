package com.iie.utils;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dev on 7/22/2014.
 */

public class DateUtilsTest {

    private static Logger LOG = Logger.getLogger(DateUtilsTest.class);

    private DateUtils dateUtils;

    @Before
    public void setUp(){
        dateUtils = new DateUtils();
    }
    @Test
    public void testIsInRage(){
        DateTime startDate = new DateTime(DateTimeZone.UTC).minusMinutes(15);
        DateTime endDate = new DateTime(DateTimeZone.UTC).plusMinutes(15);
        DateTime dateToCheck = new DateTime(DateTimeZone.UTC);
        LOG.info("start date: " + startDate);
        LOG.info("end date: " + endDate);
        LOG.info("date to check: " + dateToCheck);
        Assert.assertTrue(dateUtils.isDateInRage(startDate,endDate,dateToCheck));


    }
}
