package com.bookManagement.service.impl;

import com.bookManagement.config.ColumnNameHolder;
import com.bookManagement.dao.entity.Book;
import com.bookManagement.dao.repository.BookListingRepository;
import com.bookManagement.dto.SearchDto;
import com.bookManagement.enums.Genre;
import com.bookManagement.service.BookListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BookListingServiceServiceImpl implements BookListingService {

    @Autowired
    BookListingRepository bookListingRepository;

    @Autowired
    private ColumnNameHolder columnNameHolder;



    @Override
    public List<String> getBooks(String columnName) {
        var books = bookListingRepository.findAll();
        if (columnName != null && columnNameHolder.getColumnNameHolder().containsKey(columnName)) {
            return books.stream()
                    .map(columnNameHolder.getColumnNameHolder().get(columnName))
                    .distinct()
                    .map(Object::toString)
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Invalid filter provided: " + columnName);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookListingRepository.findAll();
    }

    @Override
    public List<String> getAllAuthors() {
        return bookListingRepository.getAllAuthors();
    }

    @Override
    public List<String> getAllLanguages() {
        return bookListingRepository.getAllLanguages();
    }

    @Override
    public List<Book> getFilteredBooks(Genre genre) {
        return bookListingRepository.getFilteredBooks(genre.name());

    }

    @Override
    public List<Book> getBooksByUserId(String userId) {
        return bookListingRepository.getBooksByUserId(userId);
    }



    @Override
    public List<Book> bookSearch(SearchDto searchDto) {
        var books = bookListingRepository.findAll();
        return searchBooks(books, searchDto);
    }

    public List<Book> searchBooks(List<Book> books, SearchDto criteria) {
        return books.stream()
                .filter(book -> matches(book, criteria))
                .collect(Collectors.toList());
    }

    private boolean matches(Book book, SearchDto criteria) {
        boolean matches = true;

        if (criteria.getBookTitle() != null && !criteria.getBookTitle().isEmpty()) {
            matches = matches && matchesRegex(book.getBookTitle(), criteria.getBookTitle());
        }
        if (criteria.getAuthor() != null && !criteria.getAuthor().isEmpty()) {
            matches = matches && matchesRegex(book.getAuthor(), criteria.getAuthor());
        }
        if (criteria.getGenre() != null) {
            matches = matches && matchesRegex(book.getGenre().name(), criteria.getGenre().name());
        }
        if (criteria.getStatus() != null) {
            matches = matches && matchesRegex(book.getStatus().name(), criteria.getStatus().name());
        }
        if (criteria.getType() != null) {
            matches = matches && matchesRegex(book.getType().name(), criteria.getType().name());
        }

        if (criteria.getLanguage() != null) {
            matches = matches && matchesRegex(book.getLanguage().name(), criteria.getLanguage().name());
        }

        return matches;
    }

    private boolean matchesRegex(String input, String regex) {
        // Use regex for matching, making it case-insensitive
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(input).find(); // Use find() to check for partial matches
    }
}