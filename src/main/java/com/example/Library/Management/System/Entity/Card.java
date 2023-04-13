package com.example.Library.Management.System.Entity;

import com.example.Library.Management.System.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "card")
@NoArgsConstructor
@AllArgsConstructor                   // boiler- plate of getter & setter
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp                 // automatically give time-stamp while creating
    private Date issueDate;            // it's datatype - Date

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    private String validTill;

    @OneToOne
    @JoinColumn                              // written always in child class
    Student student;
}
