package com.naim.spring_test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naim.spring_test.model.Book;
import com.naim.spring_test.repositories.BookDao;

@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	BookDao bookDao;

	@Override
	public Book add(Book book) {
		return bookDao.save(book);
	}


	@Override
	public Optional<Book> getBook(Long id) {
		return bookDao.findById(id);
	}

	@Override
	public List<Book> getAll() {
		return bookDao.findAll();
	}


	@Override
	public Book update(Book book) {
		return bookDao.save(book);
	}


	@Override
	public Book patch(Book book) {
		return bookDao.save(book);
	}

	@Override
	public void delete(long id) {
	 bookDao.deleteById(id);
	}


	@Override
	public List<Book> getBookByPrice(double price) {
		// TODO Auto-generated method stub
		return bookDao.getBookPrice(price);
	}
}
