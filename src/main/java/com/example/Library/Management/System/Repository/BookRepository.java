package com.example.Library.Management.System.Repository;

import com.example.Library.Management.System.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
