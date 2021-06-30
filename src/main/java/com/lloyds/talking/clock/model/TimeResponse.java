package com.lloyds.talking.clock.model;

public class TimeResponse {
    private String time;

    public TimeResponse(String time) {
        this.time = time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
