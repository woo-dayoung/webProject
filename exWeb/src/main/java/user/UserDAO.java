package user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.cj.xdevapi.PreparableStatement;

public class UserDAO {
	//Data Access Object
//	ArrayList<UserDTO> list = null;
//	private UserDAO(){
//		list = new ArrayList<UserDTO>();
//	}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private ResultSet rs =null;
	private PreparedStatement pstmt =null; 
	
	private String url="jdbc:mysql://localhost:3306/firstJsp";
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
	
	public boolean addUser(UserDTO userDto) {
		Date date = new Date(userDto.getYear()-1900,userDto.getMonth(),userDto.getDay());
		Timestamp birthdate = new Timestamp(date.getTime());
		//1.
		String sql= "insert into user values(?,?,?,?,?,?,?,?)"; //sql은 인덱스 1부터 시작
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
	
	
//	public int addUser(UserDTO userdto) {
//		// 중복 아이디 확인 후,list에 추가
//		if(checkDuple(userdto.getId())) {
//			this.list.add(userdto);
//			return this.list.size()-1;
//		}
//		return -1;
//	}
	
//	public boolean checkDuple(String id) {
//		for(UserDTO userdto : this.list) {
//			if(userdto.getId().equals(id))
//				return false;
//		}
//		return true;
//	}
	
	public boolean checklogpw(String id, String pw) {
		
		try {
			conn=getConnection();
			
			String sql= "select id from user where id=? and password=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, pw);
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
	
	public boolean deluser(String id, String pw) {
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement("delete from user where id ='"+ id+"' and pw ='"+pw+"'");
			pstmt.executeUpdate();
			System.out.println("delete 성공");
			pstmt=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("delete 실패");
			pstmt=null;
			e.printStackTrace();
		}
		return false;
	}
	
}
