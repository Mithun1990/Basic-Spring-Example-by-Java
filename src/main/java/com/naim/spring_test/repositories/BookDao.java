package com.naim.spring_test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.naim.spring_test.model.Book;

public interface BookDao extends JpaRepository<Book, Long> {
@Modifying
@Query("Select b from Book b where b.price > :price")
List<Book> getBookPrice(@Param(value = "price") double price);
}
