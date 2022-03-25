package com.javarush.task.task39.task3913;

import java.util.Date;

public class LogInfo {
    private String ip;
    private String name;
    private Date date;
    private Event event;
    private int eventNumber;
    private Status eventStatus;

    @Override
    public String toString() {
        return "LogInfo{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", event=" + event +
                ", eventNumber=" + eventNumber +
                ", eventStatus=" + eventStatus +
                '}';
    }

    public LogInfo(String ip, String name, Date date, Event event, int eventNumber, Status eventStatus) {
        this.ip = ip;
        this.name = name;
        this.date = date;
        this.event = event;
        this.eventNumber = eventNumber;
        this.eventStatus = eventStatus;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public int getEventNumber() {
        return eventNumber;
    }

    public Status getEventStatus() {
        return eventStatus;
    }
}
