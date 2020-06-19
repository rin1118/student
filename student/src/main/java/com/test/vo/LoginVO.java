package com.test.vo;

//회원가입 관련 VO
public class LoginVO {
	int s_no;
	String name;
	String email;
	String d_name;
	String id;
	String password;
	
	
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginVO [s_no=" + s_no + ", name=" + name + ", email=" + email + ", d_name=" + d_name + ", id=" + id
				+ ", password=" + password + "]";
	}
}
