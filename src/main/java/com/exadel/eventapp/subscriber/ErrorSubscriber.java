package com.exadel.eventapp.subscriber;

import com.exadel.eventapp.event.EventType;
import com.exadel.eventapp.generator.ErrorEventGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ErrorSubscriber extends Subscriber {

    @Override
    public boolean supports(EventType type) {
        return type == EventType.ERROR;
    }
}
