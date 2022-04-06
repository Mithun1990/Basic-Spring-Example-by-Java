package com.naim.spring_test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "book", uniqueConstraints = {@UniqueConstraint(columnNames = "isbn")} )
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "book_name")
	private String book_name;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "author_name")
	private String author_name;
	
	@Column(name = "publisher_name")
	private String publisher_name;
	
	@Column(name="price")
	private Double price; 
	
	@Column(name = "count")
	private int count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", book_name=" + book_name + ", isbn=" + isbn + ", author_name=" + author_name
				+ ", publisher_name=" + publisher_name + ", price=" + price + ", count=" + count + "]";
	}
}
