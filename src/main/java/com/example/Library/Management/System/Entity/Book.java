package com.example.Library.Management.System.Entity;

import com.example.Library.Management.System.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor                   // boiler- plate of getter & setter
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int numberOfPages;

    private int price;

    @ManyToOne
    @JoinColumn
    Author author;
}
