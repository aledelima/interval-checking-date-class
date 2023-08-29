package org.example;

import java.util.Date;

public class DateInterval {

    private Date startDate;
    private Date endDate;

    DateInterval(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean insideInterval(Date dateToCheck) {
        return (!dateToCheck.before(startDate) && !dateToCheck.after(endDate));
    }
}
