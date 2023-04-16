package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {

        return bookService.addBook(book);
    }

    // ------------------------------- Work (12-04-2023) --------------------------------------

                // 1. Find all the books.
                // 2. Find all the books of a particular authorId.
                // 3. Find the number of books written by a author.

    // ---------------------------------------------------------------------------------------------
}
