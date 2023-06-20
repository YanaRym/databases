package tests;

import database.DBConnection;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {

    private DBConnection dbConnection = new DBConnection();

    @Test
    public void dataBaseStudentsTest() {
        dbConnection.connect();
        try {
            ResultSet resultSet = dbConnection.selectFrom("students");
            DBConnection.writeResultSetStudents(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }

    @Test
    public void dataBaseCitiesTest() {
        dbConnection.connect();
        try {
            ResultSet resultSet = dbConnection.selectFrom("cities");
            DBConnection.writeResultSetCities(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }

    @Test
    public void dataBaseInsertIntoTest() {
        dbConnection.connect();
        dbConnection.insert("cities (Name) VALUES ('Warsaw')");
        dbConnection.insert("students (Name, Cityid) VALUES ('Alex', 4)");
        dbConnection.close();
    }
}
