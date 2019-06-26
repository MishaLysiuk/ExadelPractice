package com.exadel.eventapp.event;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EventType {

    USER, SYSTEM, CUSTOM, INFO, ERROR;

    EventType() {
    }

    private String name;

    EventType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @JsonCreator
    public static EventType create (String value) {
        if(value == null) {
            throw new IllegalArgumentException();
        }
        for(EventType v : values()) {
            if(value.equals(v.getName())) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }
}
