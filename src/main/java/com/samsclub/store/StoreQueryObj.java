package com.samsclub.store;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class StoreQueryObj {


    private String queryName = "";
    private String queryType = "";
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date queryOpeningDate;

    private String queryLocation = "";


    public StoreQueryObj() {
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public Date getQueryOpeningDate() {
        return queryOpeningDate;
    }

    public void setQueryOpeningDate(Date queryOpeningDate) {
        this.queryOpeningDate = queryOpeningDate;
    }

    public String getQueryLocation() {
        return queryLocation;
    }

    public void setQueryLocation(String queryLocation) {
        this.queryLocation = queryLocation;
    }
}
