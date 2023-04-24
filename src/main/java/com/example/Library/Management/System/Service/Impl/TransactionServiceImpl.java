package com.example.Library.Management.System.Service.Impl;

import com.example.Library.Management.System.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library.Management.System.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Entity.Card;
import com.example.Library.Management.System.Entity.Transaction;
import com.example.Library.Management.System.Enum.CardStatus;
import com.example.Library.Management.System.Enum.TransactionStatus;
import com.example.Library.Management.System.Repository.BookRepository;
import com.example.Library.Management.System.Repository.CardRepository;
import com.example.Library.Management.System.Repository.TransactionRepository;
import com.example.Library.Management.System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private JavaMailSender emailSender;


    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);


        Card card;
        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card Id !!!");
        }

        transaction.setCard(card);

        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id !!!");
        }

        transaction.setBook(book);

        if(card.getCardStatus() != CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Active !!!");
        }

        if(book.isIssued() == true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available !!!");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBookIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);                // save all three information : card, book_Id, & transaction_Id


        // prepare ResponseDto

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();

        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
        issueBookResponseDto.setBookName(book.getTitle());

        String text = "Congrats !  " + card.getStudent().getName() + " You have been issued the book " + book.getTitle();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("libraryprojectapril@gmail.com");
        message.setTo(card.getStudent().getMobNo());
        message.setSubject("Issue book");
        message.setText(text);
        emailSender.send(message);

        return issueBookResponseDto;
    }


    // ------------------------------- Home-Work (14-04-2023) --------------------------------------

                // 1. Return book API.

    // ---------------------------------------------------------------------------------------------
}
