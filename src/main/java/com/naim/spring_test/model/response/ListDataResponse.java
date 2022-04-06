package com.naim.spring_test.model.response;

import java.util.List;

import com.naim.spring_test.model.Book;

public class ListDataResponse {
	private List<Object> data;

	public ListDataResponse(List<Object> bookList) {
		this.data = bookList;
	}

	public List<Object> getBookList() {
		return data;
	}

	public void setBookList(List<Object> bookList) {
		this.data = bookList;
	}
}
