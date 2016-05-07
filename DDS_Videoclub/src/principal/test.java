package principal;

import java.sql.*;

public class test {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:data/bdvc", "sa", "sa");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM pruebas";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
