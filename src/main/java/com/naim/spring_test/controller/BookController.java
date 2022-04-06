package com.naim.spring_test.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.naim.spring_test.config.ApiConstants;
import com.naim.spring_test.model.Book;
import com.naim.spring_test.model.response.CommonListResponse;
import com.naim.spring_test.model.response.CommonResponse;
import com.naim.spring_test.model.response.ListDataResponse;
import com.naim.spring_test.model.response.CommonResponse.CommonResponseBuilder;
import com.naim.spring_test.service.IBookService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
	@Autowired
	IBookService bookService;

	@PostMapping(ApiConstants.BOOK_ENDPOINT)
	private CommonResponse addBook(@RequestBody Book book) {
		CommonResponse commonResponse = null;
		try {
			System.out.print(book);
			Book b = bookService.add(book);
			commonResponse = new CommonResponse.CommonResponseBuilder("success", "Successfully added!").data(b).build();
		} catch (Exception e) {
			commonResponse = new CommonResponse.CommonResponseBuilder("fail", e.getMessage()).build();
		}
		return commonResponse;
	}

	@GetMapping(ApiConstants.BOOK_ENDPOINT + "/{id}")
	private CommonResponse getBook(@PathVariable long id) {
		CommonResponse commonResponse = null;
		try {
			Book b = bookService.getBook(id).get();
			commonResponse = new CommonResponse.CommonResponseBuilder("success", "Successfully retrieved!").data(b)
					.build();
		} catch (Exception e) {
			commonResponse = new CommonResponse.CommonResponseBuilder("fail", e.getMessage()).build();
		}
		return commonResponse;
	}

	@GetMapping(ApiConstants.BOOK_ENDPOINT)
	CommonListResponse getAll() {
		try {
			List<Book> list = bookService.getAll();
			System.out.print(list.get(0));
			return new CommonListResponse.CommonListResponseBuilder("success", "Successfully added!").data(list).build();
		} catch (Exception e) {
			return new CommonListResponse.CommonListResponseBuilder("fail", e.getMessage()).build();
		}
	}
	
	@GetMapping(ApiConstants.BOOK_ENDPOINT+"/search/{price}")
	CommonListResponse getPrice(@PathVariable double price) {
		try {
			List<Book> list = bookService.getBookByPrice(price);
			System.out.print(list.get(0));
			return new CommonListResponse.CommonListResponseBuilder("success", "Successfully added!").data(list).build();
		} catch (Exception e) {
			return new CommonListResponse.CommonListResponseBuilder("fail", e.getMessage()).build();
		}
	}
	
	@PutMapping(ApiConstants.BOOK_ENDPOINT)
	CommonResponse update(@RequestBody Book book) {
		CommonResponse commonResponse=null;
		try {
			Book responseBook = bookService.update(book);
			commonResponse = new CommonResponse.CommonResponseBuilder("success", "Successfully updated!").data(responseBook).build();
		}catch (Exception e) {
			commonResponse = new CommonResponse.CommonResponseBuilder("fail", e.getMessage()).build();
		}
		return commonResponse;
	}
	
	@PatchMapping(ApiConstants.BOOK_ENDPOINT)
	CommonResponse patch(@RequestBody Book book) {
		CommonResponse commonResponse=null;
		try {
			Book responseBook = bookService.patch(book);
			commonResponse = new CommonResponse.CommonResponseBuilder("success", "Successfully updated!").data(responseBook).build();
		}catch (Exception e) {
			commonResponse = new CommonResponse.CommonResponseBuilder("fail", e.getMessage()).build();
		}
		return commonResponse;
	}
	
	@DeleteMapping(ApiConstants.BOOK_ENDPOINT+"/{id}")
	CommonResponse deletedById(@PathVariable long id) {
		CommonResponse commonResponse=null;
		try {
			 bookService.delete(id);
			commonResponse = new CommonResponse.CommonResponseBuilder("success", "Successfully deleted!").build();
		}catch (Exception e) {
			commonResponse = new CommonResponse.CommonResponseBuilder("fail", e.getMessage()).build();
		}
		return commonResponse;
	}
}
