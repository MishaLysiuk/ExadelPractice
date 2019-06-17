package com.exadel.eventapp.subscriber;

import com.exadel.eventapp.additional.DatePattern;
import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.event.EventType;

public abstract class Subscriber {
    public void consume(Event event) {
        System.out.printf(
                "%s successfully received event of type: %s sent on: %s with message: %s ",
                event.getClass().getSimpleName(),
                event.getType(),
                DatePattern.currentDate(event.getMillisec(), "yyyy/MM/dd hh:mm:ss"),
                event.getMessage()
        );
        System.out.println();
    }

    public abstract boolean supports(EventType type);
}
