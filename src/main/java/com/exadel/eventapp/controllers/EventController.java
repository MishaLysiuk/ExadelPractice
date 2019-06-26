package com.exadel.eventapp.controllers;

import com.exadel.eventapp.event.Event;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {

    List<Event> events = new ArrayList<>();

    @PostMapping(value = "/events")
    public String add(@RequestBody Event event, ModelMap model){
        events.add(event);
        model.addAttribute("message", "List of events");
        model.addAttribute("events", events);
        return "events";
    }

}
