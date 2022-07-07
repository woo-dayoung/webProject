package user;

import java.util.ArrayList;

public class UserDTO { //Data Tranfer Object
	private String id;
	private String password;
	private String name;
	private int year;
	private int month;
	private int day;
	private String gender;
	private String email;
	private String country;
	private String mobile;
	
	ArrayList<UserDTO> list=new ArrayList<UserDTO>();
	
	public String getPassword() {
		return password;
	}

	public void setPw(String password) {
		this.password = password;
	}

	public UserDTO(String id, String password) {
		this.id=id;
		this.password=password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public ArrayList<UserDTO> getUser() {
		return list;
	}

	public void setUser(ArrayList<UserDTO> user) {
		this.list = list;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO(String result) {
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String id,String password,String name,int year,int month,int day,String gender,String email,String country,String mobile) {
		this.id=id;
		this.password=password;
		this.name=name;
		this.year=year;
		this.month=month;
		this.day=day;
		this.gender=gender;
		this.email=email;
		this.country=country;
		this.mobile=mobile;
	}
	

	public String getId() {
		return this.id;
	}
	
	

	
	
}