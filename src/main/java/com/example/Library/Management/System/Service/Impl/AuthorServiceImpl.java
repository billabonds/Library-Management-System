package com.example.Library.Management.System.Service.Impl;

import com.example.Library.Management.System.Entity.Author;
import com.example.Library.Management.System.Repository.AuthorRepository;
import com.example.Library.Management.System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(Author author) {

        authorRepository.save(author);
        return "Author added Successfully";
    }
}
