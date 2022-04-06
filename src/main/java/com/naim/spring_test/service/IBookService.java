package com.naim.spring_test.service;

import java.util.List;
import java.util.Optional;

import com.naim.spring_test.model.Book;

public interface IBookService {
  Book add(Book book);
  Optional<Book> getBook(Long id);
  List<Book> getBookByPrice(double price);
  List<Book> getAll();
  Book update(Book book);
  Book patch(Book book);
  void delete(long id);
}
