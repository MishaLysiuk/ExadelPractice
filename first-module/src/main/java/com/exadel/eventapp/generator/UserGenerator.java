package com.exadel.eventapp.generator;

import com.exadel.eventapp.additional.Randomizer;
import com.exadel.eventapp.event.EventType;
import com.exadel.eventapp.provider.impl.UserProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserGenerator extends MainGenerator {
    private UserProvider userProvider;

    @Override
    protected String generateMessage() {
        return Randomizer.generateRandomNumber(userProvider.mapSize()).toString();
    }

    @Override
    protected EventType generateEventType() {
        return EventType.USER;
    }

}
