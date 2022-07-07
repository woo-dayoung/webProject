package user;
public class UserDTO {
	/*
	 * id password[] name year month day gender email country mobile
	 */

	private String id, pw, name;
	private int year, month, day;
	private String gender, email, country, mobile;

	// constructor

	public UserDTO(String id, String pw, String name, int year, int month, int day, String gender, String email,
			String country, String mobile) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		this.gender = gender;
		this.email = email;
		this.country = country;
		this.mobile = mobile;
	}
	public UserDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	// getter & setter
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public String getGender() {
		return gender;
	}

	public String getMobile() {
		return mobile;
	}

}
