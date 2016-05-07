package persistencia;

import java.sql.*;

public class ConnectionManager {
	private String sourceURL;
	private Connection dbcon = null;

	public ConnectionManager(String dbname) throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		sourceURL = "jdbc:hsqldb:file:./DDS_Videoclub/data/" + dbname;
	}

	public void connect() throws SQLException {
		if (dbcon == null)
				dbcon = DriverManager.getConnection(sourceURL);
	}

	public void close() throws SQLException {
		if (dbcon != null) {
				dbcon.close();
				dbcon = null;
		}
	}

	void updateDB(String sql) throws SQLException {
		if (dbcon != null) {
				Statement sentencia = dbcon.createStatement();
				sentencia.executeUpdate(sql);
		}
	}

	public ResultSet queryDB(String sql) throws SQLException {
		if (dbcon != null) {
				Statement sentencia = dbcon.createStatement();
				return sentencia.executeQuery(sql);
		}
		return null;
	}
}