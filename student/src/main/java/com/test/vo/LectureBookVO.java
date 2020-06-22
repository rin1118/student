package com.test.vo;

public class LectureBookVO {
	private int s_no;
	private int l_no;
	private String grade;
	
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public int getL_no() {
		return l_no;
	}
	public void setL_no(int l_no) {
		this.l_no = l_no;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "LectureBookVO [s_no=" + s_no + ", l_no=" + l_no + ", grade=" + grade + "]";
	}
}
