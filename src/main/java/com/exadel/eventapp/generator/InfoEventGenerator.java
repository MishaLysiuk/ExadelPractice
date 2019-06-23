package com.exadel.eventapp.generator;

import com.exadel.eventapp.event.EventType;

public class InfoEventGenerator extends MainGenerator {

    @Override
    protected String generateMessage() {
        return "INFO";
    }

    @Override
    protected EventType generateEventType() {
        return EventType.INFO;
    }
}
