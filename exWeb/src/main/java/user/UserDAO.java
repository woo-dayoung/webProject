package user;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO { // Data Access Object
	
	//Singleton Pattern
	private UserDAO() {
	}
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return instance;
	}
	ArrayList<UserDTO> list=null;
	// mysql local DB
	//1. lib > mysql-connector-driver 라이브러리(.jar)를 넣기(maven repository > mysql java )
	//2. 데이터베이스 연동 Connection 클래스 import(java.sql)
	Connection conn=null;
	ResultSet rs = null;
	PreparedStatement pstmt =null;
	
	public boolean addUser(UserDTO userDto) {
		Date date = new Date(userDto.getYear()-1900,userDto.getMonth(),userDto.getDay());
		Timestamp birthdate = new Timestamp(date.getTime());
		//1.
		String sql= "insert into users values(?,?,?,?,?,?,?,?)"; //sql은 인덱스 1부터 시작
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setString(3, userDto.getName());
			pstmt.setTimestamp(4, birthdate);
			pstmt.setInt(5, userDto.getGender().equals("man") ? 1 : 2);
			pstmt.setString(6, userDto.getEmail());
			pstmt.setString(7, userDto.getCountry());
			pstmt.setString(8, userDto.getMobile());
			
			boolean suc =pstmt.execute();
			System.out.println(suc);
			//pstmt (쿼리 날릴) 준비 완료
			if(!suc) {
				System.out.println("insert 완료");
				pstmt=null;
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert 실패");
			pstmt=null;
			e.printStackTrace();
		}
		return false;
		
		//pstmt (쿼리 날릴) 준비 완료
		
		//2. Select 조회
		/*sql = "select * from users where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "apple");
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString(1);
			String password = rs.getString(2);
			String name = rs.getString(4);
			Timestamp birthdaters = rs.getTimestamp(4);
			int gender = rs.getInt(5);
			String email = rs.getString(6);
			String country = rs.getString(7);
			String mobile = rs.getString(8);
			
			UserDTO user = new UserDTO(id, password,birthdaters.getYear(), birthdaters.getMonth()+1, birthdaters.getDate());
		}
		*/
		
	}

	public int addUser(UserDTO userdto) {
		// 중복 아이디 확인 후,list에 추가
		if(checkDuple(userdto.getId())) {
			this.list.add(userdto);
			return this.list.size()-1;
		}
		return -1;
	}
	
	public boolean checkDuple(String id) {
		for(UserDTO userdto : this.list) {
			if(userdto.getId().equals(id))
				return false;
		}
		return true;
	}
	
	public boolean checklogpw(String id, String pw) {
		try {
			getConnection();
			pstmt= conn.prepareStatement("select id from users where id ='"+ id+"' and pw ='"+pw+"'");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	public UserDTO getUser(String id) {
		UserDTO user = null;
		conn=UserDAO.getConnection();
		try {
			String sql="select * from User where name = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String result = rs.getString(1);
				user = new UserDTO(result);
			}
		} catch (Exception e) {}
		finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return user;
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		
		 String url="jdbc:mysql://localhost:3306/firstjsp";
		 String user="root";
		 String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("DB연동 성공");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	
	
}
