package com.exadel.eventapp.generator;

import com.exadel.eventapp.event.EventType;

public class ErrorGenerator extends MainGenerator {

    @Override
    protected String generateMessage() {
        return "Error";
    }

    @Override
    protected EventType generateEventType() {
        return EventType.ERROR;
    }
}
