package com.example.Library.Management.System.Service.Impl;

import com.example.Library.Management.System.Entity.Card;
import com.example.Library.Management.System.Repository.StudentRepository;
import com.example.Library.Management.System.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addCard(Card card) {

        return "Card added successfully";
    }
}
