package board;

public class BoardDTO {
	
	/*
	 * `no` int not null,
    `code` int primary key, -- 4자리 랜덤 숫자 
    title varchar(100) not null,
    contents varchar(4000) not null,
    viewCnt int default 0,
    likeCnt int default 0,
    createdAt datetime,
    modifiedAt datetime
	 * 
	 */
	
	private int no,code,viewCnt,likeCnt;
	private String title,contents;
	private int year, month, day;
	
	public BoardDTO(int no,int code,int viewCnt,int likeCnt,String title,
			String contents,int year, int month, int day) {
		this.no=no;
		this.code=code;
		this.viewCnt=viewCnt;
		this.likeCnt=likeCnt;
		this.title=title;
		this.contents=contents;
		this.year=year;
		this.month=month;
		this.day=day;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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
	

}
