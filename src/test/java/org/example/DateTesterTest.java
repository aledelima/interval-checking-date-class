package org.example;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateIntervalTest {

    private final String INTERVAL_BEGIN = "2023-08-01";
    private final String INTERVAL_END = "2023-08-31";

    private DateInterval dateInterval;


    DateIntervalTest() throws ParseException {

        Date startDate = createDateFromString(INTERVAL_BEGIN); //dateFormat.parse(INTERVAL_BEGIN);
        Date endDate = createDateFromString(INTERVAL_END); //dateFormat.parse(INTERVAL_END);
        this.dateInterval = new DateInterval(startDate, endDate);
    }

    @Test
    void beforeIntervalBeginMustReturnFalse() throws ParseException {
        String STRING_DATE = "2023-07-15";
        Date dateToCheck = createDateFromString(STRING_DATE);
        assertFalse(dateInterval.insideInterval(dateToCheck));
    }

    @Test
    void preciselyOnTheIntervalBeginMustReturnTrue() throws ParseException {
        String STRING_DATE = "2023-08-01";
        Date dateToCheck = createDateFromString(STRING_DATE);
        assertTrue(dateInterval.insideInterval(dateToCheck));
    }

    @Test
    void betweenTheIntervalBoundsMustReturnTrue() throws ParseException {
        String STRING_DATE = "2023-08-15";
        Date dateToCheck = createDateFromString(STRING_DATE);
        assertTrue(dateInterval.insideInterval(dateToCheck));
    }

    @Test
    void preciselyOnTheIntervalEndMustReturnTrue() throws ParseException {
        String STRING_DATE = "2023-08-31";
        Date dateToCheck = createDateFromString(STRING_DATE);
        assertTrue(dateInterval.insideInterval(dateToCheck));
    }

    @Test
    void afterIntervalEndMustReturnFalse() throws ParseException {
        String STRING_DATE = "2023-09-15";
        Date dateToCheck = createDateFromString(STRING_DATE);
        assertFalse(dateInterval.insideInterval(dateToCheck));
    }

    private Date createDateFromString(String s) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(s);
    }
}