package com.exadel.eventapp.publisher.impl;

import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.eventstorage.EventStorage;
import com.exadel.eventapp.generator.MainGenerator;
import com.exadel.eventapp.publisher.Publisher;
import com.exadel.eventapp.additional.Randomizer;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PublisherImpl implements Publisher {

    private EventStorage events;

    private List<MainGenerator> generators;

    @Override
    public void publish(){
        MainGenerator generator = generators.get(Randomizer.generateRandomNumber(generators.size()));

        Event event = generator.generate();

        events.put(event);
    }
}
