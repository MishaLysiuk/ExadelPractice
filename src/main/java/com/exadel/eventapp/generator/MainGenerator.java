package com.exadel.eventapp.generator;

import com.exadel.eventapp.additional.Generator;
import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.event.EventType;

public abstract class MainGenerator implements Generator<Event> {
    public Event generate(){
        return new Event();/*Event.builder()
                .millisec(System.currentTimeMillis())
                .type(generateEventType())
                .message(generateMessage())
                .build();*/
    }

    protected abstract String generateMessage();

    protected abstract EventType generateEventType();
}
