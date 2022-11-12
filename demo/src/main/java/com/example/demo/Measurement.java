package com.example.demo;

public class Measurement {

    private String value;
    private String timestampOf;
    private String status;
    private int id_location;

    public Measurement(String value, String timestampOf, String status,int id_location) {
        this.status = status;
        this.value = value;
        this.timestampOf = timestampOf;
        this.id_location = id_location;
    }
    public Measurement() {
    }

    public String getValue() {
        return value;
    }

    public String getTimestampOf() {
        return timestampOf;
    }
    public String getStatus() {
        return status;
    }
    public int getId_location() {
        return id_location;
    }
    public void setId_location(int id_location) {
        this.id_location = id_location;
    }
    public void setTimestampOf(String timestampOf) {
        this.timestampOf = timestampOf;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
