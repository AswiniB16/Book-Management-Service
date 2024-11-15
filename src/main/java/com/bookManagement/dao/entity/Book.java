package com.bookManagement.dao.entity;

import com.bookManagement.enums.Genre;
import com.bookManagement.enums.Language;
import com.bookManagement.enums.Status;
import com.bookManagement.enums.Type;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String userId;
    public String bookTitle;
    @Enumerated(EnumType.STRING)
    public Type type;
    public String author;
    @Enumerated(EnumType.STRING)
    public Genre genre;
    public String location;
    @Enumerated(EnumType.STRING)
    public Status status;
    public LocalDate publishedDate;
    @Enumerated(EnumType.STRING)
    public Language language;

}
