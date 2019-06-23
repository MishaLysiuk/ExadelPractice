package com.exadel.eventapp.generator;

import com.exadel.eventapp.event.EventType;

public class SystemEventGenerator extends MainGenerator {

    @Override
    protected String generateMessage() {
        return "SYSTEM";
    }

    @Override
    protected EventType generateEventType() {
        return EventType.SYSTEM;
    }

}
