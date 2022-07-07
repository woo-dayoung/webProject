package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDAO {
	
	private Connection conn = null;
	private ResultSet rs =null;
	private PreparedStatement pstmt =null; 
	
	private String url="jdbc:mysql://localhost:3306/firstjsp";
	private String user ="root";
	private String password = "root";
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			return conn;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
