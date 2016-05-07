package principal;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {
    public static void main (String[] args){
        try {
            String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            Class.forName(driver).newInstance();
            String dbURL = "jdbc:derby:data\\dbvideoclub;create=true";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from peliculas");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
