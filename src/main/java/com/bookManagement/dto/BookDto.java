package com.bookManagement.dto;

import com.bookManagement.enums.Genre;
import com.bookManagement.enums.Language;
import com.bookManagement.enums.Type;
import com.bookManagement.enums.Status;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Builder
public class BookDto {

    private Integer id;
    public String userId;
    public String bookTitle;
    public Type type;
    public String author;
    public Genre genre;
    public String location;
    public Status status;
    public Language language;
    public LocalDate publishedDate;

}
