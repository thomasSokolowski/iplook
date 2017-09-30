package com.iie.service;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by dev on 7/23/2014.
 */
public interface CommonService {

    boolean isArrived(DateTime dateTime);

    List<?> listAllRecordsOlderThanDate(DateTime dateTime);

    void dropOlderThanDate(DateTime dateTime);
}
