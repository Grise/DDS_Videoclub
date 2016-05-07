package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:testdb");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
