package com.exadel.eventapp.event;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

public class Event implements Serializable {

    private static final long serialVersionUID=1L;

    private Long millisec;
    private EventType type;
    private String message;

    public Event() {
    }

    public Long getMillisec() {
        return millisec;
    }

    public void setMillisec(Long millisec) {
        this.millisec = millisec;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
