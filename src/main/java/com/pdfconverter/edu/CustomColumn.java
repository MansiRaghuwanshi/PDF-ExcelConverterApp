package com.pdfconverter.edu;

import java.util.HashMap;
import java.util.Map;

import static com.pdfconverter.edu.Constants.*;


public class CustomColumn {

    // It needs to be mapped to column name provided in Excel.
    private Map<String, String> keyValueMap = new HashMap<>();


    public String getStateName() {
        return keyValueMap.get(EXCEL_STATE_NAME);
    }

    public void setStateName(String stateName) {
        keyValueMap.put(EXCEL_STATE_NAME, stateName);
    }

    public String getStartDate() {
        return keyValueMap.get(EXCEL_START_DATE);
    }

    public void setStartDate(String startDate) {
        keyValueMap.put(EXCEL_START_DATE, startDate);
    }

    public String getEndDate() {
        return keyValueMap.get(EXCEL_END_DATE);
    }

    public void setEndDate(String endDate) {
        keyValueMap.put(EXCEL_END_DATE, endDate);
    }

    public String getRatingArea() {
        return keyValueMap.get(EXCEL_RATING_AREA);
    }

    public void setRatingArea(String ratingArea) {
        keyValueMap.put(EXCEL_RATING_AREA, ratingArea);
    }

    public String getPlanId() {
        return keyValueMap.get(EXCEL_PRODUCT_ID);
    }


    public void setPlanId(String planId) {
        keyValueMap.put(EXCEL_PRODUCT_ID, planId);
    }

    public String getPlanName() {
        return keyValueMap.get(EXCEL_PRODUCT_NAME);
    }

    public void setPlanName(String planName) {
        keyValueMap.put(EXCEL_PRODUCT_NAME, planName);
    }

    public Map<String, String> getAgetToRateMap() {
        return keyValueMap;
    }

    public void setAgetToRateMap(Map<String, String> agetToRateMap) {
        keyValueMap.putAll(agetToRateMap);
    }

}
