package principal;

import persistencia.ConnectionManager;

import java.sql.*;

public class test {

    public static void main(String[] args) {
        try {
            ConnectionManager connectionManager = new ConnectionManager("bdvc");
            connectionManager.connect();
            connectionManager.queryDB("create table pruebas(id bigint)");
            connectionManager.queryDB("insert into pruebas values (1)");
            connectionManager.queryDB("insert into pruebas values (2)");
            connectionManager.queryDB("insert into pruebas values (3)");
            ResultSet rs = connectionManager.queryDB("select * from pruebas");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }
            connectionManager.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
