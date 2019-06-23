package com.exadel.eventapp.generator;

import com.exadel.eventapp.event.EventType;

public class CustomEventGenerator extends MainGenerator {

    @Override
    protected String generateMessage() {
        return "CUSTOM";
    }

    @Override
    protected EventType generateEventType() {
        return EventType.CUSTOM;
    }
}