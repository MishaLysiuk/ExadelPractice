package com.exadel.eventapp.jdbc.service.impl;

import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.jdbc.dao.IEventDao;
import com.exadel.eventapp.jdbc.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EventServiceImpl implements IEventService {

    private IEventDao dao;

    @Autowired
    public EventServiceImpl(IEventDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(final Event entity) throws SQLException {
        dao.insert(entity);
    }
}
