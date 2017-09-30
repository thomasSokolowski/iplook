/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iie.utils;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.stereotype.Component;

/**
 *
 * @author dev
 */
@Component
public class DateUtils {

    public boolean isDateInRage(DateTime startDate, DateTime endDate, DateTime dateToCheck) {
        return !(dateToCheck.isBefore(startDate) || dateToCheck.isAfter(endDate));
    }
}
