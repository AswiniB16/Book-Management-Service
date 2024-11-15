package com.bookManagement.service;

import com.bookManagement.dto.BookDto;
import java.util.List;

public interface ManageBooksService {
    List<com.bookManagement.dao.entity.Book> save(List<BookDto> bookDto);
    void deleteBookById(Integer id);
    List<com.bookManagement.dao.entity.Book> updateBookInfo(List<BookDto> bookDtos);
}
