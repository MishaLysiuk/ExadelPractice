package com.exadel.eventapp.generator;

import com.exadel.eventapp.event.EventType;

public class SystemGenerator extends MainGenerator {

    @Override
    protected String generateMessage() {
        return "SYSTEM";
    }

    @Override
    protected EventType generateEventType() {
        return EventType.SYSTEM;
    }

}
