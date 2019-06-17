package com.exadel.eventapp.subscriber;

import com.exadel.eventapp.additional.DatePattern;
import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.event.EventType;
import com.exadel.eventapp.provider.impl.UserProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserSubscriber extends Subscriber {

    private UserProvider userProvider;

    @Override
    public void consume(Event event) {
        System.out.printf(
                "%s successfully received event of type: %s sent on: %s with message: %s User: %s ",
                event.getClass().getSimpleName(),
                event.getType(),
                DatePattern.currentDate(event.getMillisec(), "yyyy/MM/dd hh:mm:ss"),
                event.getMessage(),
                userProvider.getById(Integer.valueOf(event.getMessage()))
        );
    }

    @Override
    public boolean supports(EventType type) {
        return type == EventType.USER;
    }
}
