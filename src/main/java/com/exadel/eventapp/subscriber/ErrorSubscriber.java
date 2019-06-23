package com.exadel.eventapp.subscriber;

import com.exadel.eventapp.event.EventType;

public class ErrorSubscriber extends Subscriber {
    @Override
    public boolean supports(EventType type) {
        return type == EventType.ERROR;
    }
}
