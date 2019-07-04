package com.exadel.eventapp.jdbc.dao.impl;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.sql.*;

public abstract class AbstractDao {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @PostConstruct
    private void init() {

        if (url == null) {
            throw new IllegalArgumentException("[url] cant be null");
        }

        if (password == null) {
            throw new IllegalArgumentException("[password] cant be null");
        }

        if (user == null) {
            throw new IllegalArgumentException("[user] cant be null");
        }
    }

    protected Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url,
                user, password);
    }

}
