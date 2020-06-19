package com.test.vo;

public class DepartmentVO {
	int d_no;
	String name;
	
	public int getD_no() {
		return d_no;
	}
	public void setD_no(int d_no) {
		this.d_no = d_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "DepartmentVO [d_no=" + d_no + ", name=" + name + "]";
	}
	
}
