package com.exadel.eventapp.jdbc.dao.impl;

import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.jdbc.EventMapper;
import com.exadel.eventapp.jdbc.dao.IEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;


@Component
public class EventDaoImpl implements IEventDao {

    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_Event = "select * from event where id = ?";
    private final String SQL_DELETE_Event = "delete from event where id = ?";
    private final String SQL_UPDATE_Event = "update event set millisec = ?, type = ?, message  = ? where id = ?";
    private final String SQL_GET_ALL = "select * from event";
    private final String SQL_INSERT_Event = "insert into event(millisec, type, message) values(?,?,?)";

    @Autowired
    public EventDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Event getEventById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_Event, new Object[]{id}, new EventMapper());
    }

    @Override
    public List<Event> getAllEvents() {
        return jdbcTemplate.query(SQL_GET_ALL, new EventMapper());
    }

    @Override
    public boolean deleteEvent(Event Event) {
        return jdbcTemplate.update(SQL_DELETE_Event, Event.getId()) > 0;
    }

    @Override
    public boolean updateEvent(Event Event) {
        return jdbcTemplate.update(SQL_UPDATE_Event, Event.getMillisec(), Event.getType(), Event.getMessage(),
                Event.getId()) > 0;
    }

    @Override
    public boolean createEvent(Event Event) {
        return jdbcTemplate.update(SQL_INSERT_Event, Event.getMillisec(), Event.getType().toString(), Event.getMessage()) > 0;
    }
}
