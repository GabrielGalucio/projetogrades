package trabalho.model.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection con = null;
	private String hostname = null;
	private String username = null;
	private String password = null;
	private String url = null;
	private String databasename = null;
	private String databaseprefix = null;
	private String databaseport = null;
	private String jdbcdriver = null;
	
	public ConnectionFactory() {
		this.hostname = "localhost";
		this.username = "root";
		this.password = "1234";
		this.jdbcdriver = "com.mysql.jdbc.Driver";
		this.databasename = "trabalhotw1";
		this.databaseprefix = "jdbc:mysql://";
		this.databaseport = "3306";

		this.url = this.databaseprefix + this.hostname + ":" + this.databaseport + "/" + this.databasename;
	}
	
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		if(this.con == null) {
			Class.forName(this.jdbcdriver);
			this.con = DriverManager.getConnection(this.url, this.username, this.password);
		} else if(this.con.isClosed()) {
			this.con = null;
			return getConnection();
		}
		
		return this.con;
	}
	
	public void closeConnection() throws SQLException {
		if (con != null) {
			con.close();
		}
	}
}