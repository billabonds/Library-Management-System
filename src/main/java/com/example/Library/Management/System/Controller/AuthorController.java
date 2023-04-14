package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library.Management.System.Entity.Author;
import com.example.Library.Management.System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){

        return authorService.addAuthor(author);
    }

    @GetMapping("/get_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam String email){

        return authorService.getByEmail(email);
    }


    // ------------------------------- Home-Work (13-04-2023) --------------------------------------

            // 1. Get all the authors of a particular age.

    // ---------------------------------------------------------------------------------------------
}
