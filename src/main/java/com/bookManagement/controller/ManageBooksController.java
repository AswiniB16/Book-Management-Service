package com.bookManagement.controller;

import com.bookManagement.dto.BookDto;
import com.bookManagement.service.ManageBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/bookexchangeplatform")
public class ManageBooksController {

    @Autowired
    ManageBooksService manageBooksService;

    @PostMapping(value = "/books")
    public void saveBooks(@RequestBody List<BookDto> bookDtos) {
        manageBooksService.save(bookDtos);
    }

    @DeleteMapping(value="/books/{id}")
    public void deleteBookById(@PathVariable Integer id){
        manageBooksService.deleteBookById(id);
    }

    @PatchMapping(value="/books")
    public List<com.bookManagement.dao.entity.Book> updateBookInfo(@RequestBody List<BookDto> bookDtos){
        return manageBooksService.updateBookInfo(bookDtos);
    }
}
