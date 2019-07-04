package com.exadel.eventapp.jdbc.dao;

import com.exadel.eventapp.event.Event;

import java.sql.SQLException;

public interface IEventDao {
    void insert(Event entity) throws SQLException;
}
