package com.exadel.eventapp.controllers;

import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.eventstorage.EventStorage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger("com.exadel.eventapp.controllers.EventController");

    private final EventStorage events;

    @PostMapping(value = "/events")
    public void add(@RequestBody Event event) {
        events.put(event);
        LOGGER.info("Event has added to list SUCCESSFULLY");
    }
}
