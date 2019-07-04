package com.exadel.eventapp.jdbc.service;

import com.exadel.eventapp.event.Event;

import java.sql.SQLException;

public interface IEventService {
    void save(Event entity) throws SQLException;
}
