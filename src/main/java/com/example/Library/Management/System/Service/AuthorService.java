package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library.Management.System.Entity.Author;
import org.springframework.web.bind.annotation.RequestParam;

public interface AuthorService {

    public String addAuthor(Author author);

    public AuthorResponseDto getByEmail(String email);
}
