package com.bookManagement.dao.repository;

import com.bookManagement.dao.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManageBooksRepository extends JpaRepository<Book,Integer> {

}
