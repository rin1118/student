package com.test.vo;

import java.util.Date;

public class BambooVO {
	int b_no;
	String ip;
	String writer;
	String title;
	String description;
	String category;
	String searchValue;
	Date regDate;
	int password;
	int favorite;
	int notFav;
	
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public int getFavorite() {
		return favorite;
	}
	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}
	
	public int getNotFav() {
		return notFav;
	}
	public void setNotFav(int notFav) {
		this.notFav = notFav;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	@Override
	public String toString() {
		return "BambooVO [b_no=" + b_no + ", ip=" + ip + ", writer=" + writer + ", title=" + title + ", description="
				+ description + ", category=" + category + ", searchValue=" + searchValue + ", regDate=" + regDate
				+ ", password=" + password + ", favorite=" + favorite + ", notFav=" + notFav + "]";
	}
	
}
