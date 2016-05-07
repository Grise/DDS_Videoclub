package principal;

import persistencia.ConnectionManager;

import java.sql.*;

public class test {

    public static void main(String[] args) {
        try {
            ConnectionManager connectionManager = new ConnectionManager("dbvideoclub");
            connectionManager.connect();
            ResultSet rs = connectionManager.queryDB("select * from pruebas");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }
            connectionManager.close();
            System.out.println("Desconectado de la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
