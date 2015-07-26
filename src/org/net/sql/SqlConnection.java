package org.net.sql;

public class SqlConnection {
	private String host,username,password,dbname;
	

	public SqlConnection(String host, String username, String password,
			String dbname) {

		this.host = host;
		this.username = username;
		this.password = password;
		this.dbname = dbname;
	}
	public SqlConnection() {
		// TODO Auto-generated constructor stub
		this.host = "localhost";
		this.username = "root";
		this.password = "";
		this.dbname = "";
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	
	



}
