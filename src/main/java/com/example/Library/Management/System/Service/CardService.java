package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.Card;
import org.springframework.web.bind.annotation.RequestBody;

public interface CardService {

    public String addCard(Card card);
}
