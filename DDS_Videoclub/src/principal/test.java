/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author The PinkyCandy
 */
public class test {
    public static void main (String[] args){
        String dbURL = "jdbc:derby:C:\\Users\\The PinkyCandy\\Documents\\NetBeansProjects\\DDS_Videoclub\\DDS_Videoclub\\data\\dbvideoclub;create=true";
        try {
            Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String query = "select * from peliculas;";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
