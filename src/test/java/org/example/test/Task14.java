package org.example.test;

import org.example.common.VolunteerDBService;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

public class Task14 {
    @Test
    public void createVolunteerUsingJDBC() throws SQLException {
        VolunteerDBService service = new VolunteerDBService();
        service.selectFromUsersTable();
        service.closeConnectionsAndStatements();
    }
}
