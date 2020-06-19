package com.test.vo;

public class SearchVO {
	String category;
	String searchValue;
	
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
		return "SearchVO [category=" + category + ", searchValue=" + searchValue + "]";
	}
	
	
}
