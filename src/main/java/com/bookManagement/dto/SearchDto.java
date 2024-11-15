package com.bookManagement.dto;

import com.bookManagement.enums.Genre;
import com.bookManagement.enums.Language;
import com.bookManagement.enums.Status;
import com.bookManagement.enums.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchDto {
    public String bookTitle;
    public Type type;
    public String author;
    public Genre genre;
    public Status status;
    private Language language;
}
