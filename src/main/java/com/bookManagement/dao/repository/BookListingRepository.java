package com.bookManagement.dao.repository;

import com.bookManagement.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookListingRepository extends JpaRepository<Book,Integer> {

    @Query("Select Distinct b.author from Book b")
    List<String> getAllAuthors();

    @Query("Select Distinct b.language from Book b")
    List<String> getAllLanguages();

    @Query(value = "SELECT * FROM book b WHERE b.genre = ?1", nativeQuery = true)
    List<Book> getFilteredBooks(String genre);

    @Query(value = "SELECT * FROM book b WHERE b.user_id = ?1", nativeQuery = true)
    List<Book> getBooksByUserId(String userId);
}
