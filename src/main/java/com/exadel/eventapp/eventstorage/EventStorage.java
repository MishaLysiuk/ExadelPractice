package com.exadel.eventapp.eventstorage;

import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.subscriber.Subscriber;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

@RequiredArgsConstructor
public class EventStorage {

    private final List<Subscriber> subscribers;

    private Queue<Event> events = new LinkedList<>();

    public void put(Event event) {
        events.add(event);
    }

    public void receive() {
        Event head = events.poll();
        if (head != null) {
            Optional<Subscriber> matchedSubscriber = subscribers.stream()
                    .filter(
                            subscriber -> head.getType() != null && subscriber.supports(head.getType())
                    )
                    .findFirst();
            matchedSubscriber.ifPresent(subscriber -> subscriber.consume(head));
        }
    }
}
