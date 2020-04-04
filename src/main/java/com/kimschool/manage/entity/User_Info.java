package com.kimschool.manage.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // jpa전용 필수 어노테이션
public class User_Info {

	private String id;
	@Id // pk에다가 지정해주는 어노테이션
	private int no;
	private String password;
	private String auth1;
	private String status;
	private String reg_date;
	private String email;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuth1() {
		return auth1;
	}
	public void setAuth1(String auth1) {
		this.auth1 = auth1;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User_Info [id=" + id + ", no=" + no + ", password=" + password + ", auth1=" + auth1 + ", status="
				+ status + ", reg_date=" + reg_date + ", email=" + email + "]";
	}

}
