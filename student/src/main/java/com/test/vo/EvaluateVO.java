package com.test.vo;

import java.util.Date;

public class EvaluateVO {
	private int e_no; 	// 강의 평가 글 번호
	private int l_no; 		// 강의 번호
	private int s_no;		// 학번이였음 (아마 안씀)
	private int m_no;		// 멤버번호 (학번 대신 쓰임)
	private String description;
	private Date regDate;
	private String title;
	private String professor;
	private String category;
	
	
	@Override
	public String toString() {
		return "EvaluateVO [e_no=" + e_no + ", l_no=" + l_no + ", s_no=" + s_no + ", m_no=" + m_no + ", description="
				+ description + ", regDate=" + regDate + ", title=" + title + ", professor=" + professor + ", category="
				+ category + "]";
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getE_no() {
		return e_no;
	}
	public void setE_no(int e_no) {
		this.e_no = e_no;
	}
	public int getL_no() {
		return l_no;
	}
	public void setL_no(int l_no) {
		this.l_no = l_no;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
