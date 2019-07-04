package com.exadel.eventapp.controllers;

import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.eventstorage.EventStorage;
import com.exadel.eventapp.jdbc.service.IEventService;
import com.exadel.eventapp.jdbc.service.impl.EventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
//@RequiredArgsConstructor
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger("com.exadel.eventapp.controllers.EventController");

    @Autowired
    private IEventService dao;
    //private final EventStorage events;

    @PostMapping(value = "/events")
    public void add(@RequestBody Event event) throws SQLException {
        dao.save(event);
        LOGGER.info("Event has added to list SUCCESSFULLY");
    }
}
