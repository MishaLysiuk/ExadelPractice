package com.exadel.eventapp.jdbc.dao.impl;

import com.exadel.eventapp.event.Event;
import com.exadel.eventapp.jdbc.dao.IEventDao;
import org.springframework.stereotype.Repository;

import java.sql.*;


@Repository
public class EventDaoImpl extends AbstractDao implements IEventDao {

    @Override
    public void insert(Event entity) throws SQLException {

        try (Connection conn = createConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into event (millisec, type, message) values(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1,entity.getMillisec());
            stmt.setObject(2,entity.getType());
            stmt.setString(3,entity.getMessage());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                // Retrieve the auto generated key(s).
                int generatedId = rs.getInt(1);
                entity.setId(generatedId);
            }
        }
    }
}
