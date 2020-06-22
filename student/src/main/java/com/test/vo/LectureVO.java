package com.test.vo;

public class LectureVO {
	
	private int l_no;
	private int p_no;
	private String title;
	private String description;
	private String category;
	private String professor;
	
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public int getL_no() {
		return l_no;
	}
	public void setL_no(int l_no) {
		this.l_no = l_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	
	@Override
	public String toString() {
		return "LeactureVO [l_no=" + l_no + ", title=" + title + ", description=" + description + ", category="
				+ category + ", professor=" + professor + "]";
	}
	
	
}
