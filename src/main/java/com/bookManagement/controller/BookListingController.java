package com.bookManagement.controller;

import com.bookManagement.dao.entity.Book;
import com.bookManagement.dto.SearchDto;
import com.bookManagement.service.BookListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/bookexchangeplatform")
public class BookListingController {

    @Autowired
    BookListingService bookListingService;

    @GetMapping(value = "/books")
    public List<String> getBooks(@RequestParam(value = "columnName", required = false) String columnName) {
        return bookListingService.getBooks(columnName);
    }

    @GetMapping(value = "/all-books")
    public List<Book> getAllBooks() {
        return bookListingService.getAllBooks();
    }

    @GetMapping(value = "/books/{userId}")
    public List<Book> getBooksByUserId(@PathVariable String userId) {
        return bookListingService.getBooksByUserId(userId);
    }

    @PostMapping(value = "/books/search")
    public List<Book> getFilteredBooks(@RequestBody SearchDto searchDto) {
        return bookListingService.bookSearch(searchDto);
    }
}
