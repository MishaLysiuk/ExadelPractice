package com.exadel.eventapp.event;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EventType {

    USER, SYSTEM, CUSTOM, INFO, ERROR;

    private String name;

    EventType() {
    }

    EventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @JsonCreator
    public static EventType create(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        for (EventType v : values()) {
            if (value.equals(v.getName())) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }

}
