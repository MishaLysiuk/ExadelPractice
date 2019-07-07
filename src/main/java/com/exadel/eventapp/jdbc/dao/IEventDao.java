package com.exadel.eventapp.jdbc.dao;

import com.exadel.eventapp.event.Event;

import java.util.List;

public interface IEventDao {
    Event getEventById(Long id);

    List<Event> getAllEvents();

    boolean deleteEvent(Event Event);

    boolean updateEvent(Event Event);

    boolean createEvent(Event Event);
}
