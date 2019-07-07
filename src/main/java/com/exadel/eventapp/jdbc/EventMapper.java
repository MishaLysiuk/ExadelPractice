package com.exadel.eventapp.jdbc;

import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.event.EventType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event Event = new Event();
        Event.setId(resultSet.getInt("id"));
        Event.setMillisec(resultSet.getLong("millisec"));
        Event.setType((EventType) resultSet.getObject("type"));
        Event.setMessage(resultSet.getString("message"));
        return Event;
    }
}
