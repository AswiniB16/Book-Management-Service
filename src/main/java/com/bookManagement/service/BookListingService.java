package com.bookManagement.service;

import com.bookManagement.dao.entity.Book;
import com.bookManagement.dto.SearchDto;
import com.bookManagement.enums.Genre;

import java.util.List;

public interface BookListingService {


    List<String> getBooks(String columnName);

    List<Book> getAllBooks();

    List<String> getAllAuthors();

    List<String> getAllLanguages();

    List<Book> getFilteredBooks(Genre genre);

    List<Book> getBooksByUserId(String userId);



    List<Book> bookSearch(SearchDto searchDto);
}
