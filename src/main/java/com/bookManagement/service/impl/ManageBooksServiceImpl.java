package com.bookManagement.service.impl;

import com.bookManagement.dao.repository.ManageBooksRepository;
import com.bookManagement.dto.BookDto;
import com.bookManagement.service.ManageBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManageBooksServiceImpl implements ManageBooksService {

    @Autowired
    ManageBooksRepository manageBooksRepository;

    @Override
    public List<com.bookManagement.dao.entity.Book> save(List<BookDto> bookDtos) {
        List<com.bookManagement.dao.entity.Book> bookEntities = new ArrayList<>();
        bookDtos.stream().forEach(bookDto -> {
            var bookEntity = com.bookManagement.dao.entity.Book.builder()
                    .userId(bookDto.userId).bookTitle(bookDto.bookTitle).author(bookDto.author)
                    .location(bookDto.location).genre(bookDto.genre).publishedDate(bookDto.publishedDate)
                    .status(bookDto.status).type(bookDto.type).language(bookDto.getLanguage())
                    .build();
            bookEntities.add(bookEntity);
        });


        return manageBooksRepository.saveAll(bookEntities);
    }

    @Override
    public void deleteBookById(Integer id) {
        manageBooksRepository.deleteById(id);
    }

    @Override
    public List<com.bookManagement.dao.entity.Book> updateBookInfo(List<BookDto> bookDtos) {
        List<com.bookManagement.dao.entity.Book> bookEntities = new ArrayList<>();
        bookDtos.stream().forEach(bookDto -> {
            var bookEntity = com.bookManagement.dao.entity.Book.builder()
                    .id(bookDto.getId())
                    .userId(bookDto.userId).bookTitle(bookDto.bookTitle).author(bookDto.author)
                    .location(bookDto.location).genre(bookDto.genre).publishedDate(bookDto.publishedDate)
                    .status(bookDto.status).type(bookDto.type).language(bookDto.getLanguage()).build();
            bookEntities.add(bookEntity);
        });


        return manageBooksRepository.saveAll(bookEntities);
    }
}
