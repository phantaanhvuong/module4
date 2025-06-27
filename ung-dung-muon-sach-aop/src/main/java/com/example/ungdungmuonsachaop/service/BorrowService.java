package com.example.ungdungmuonsachaop.service;

import com.example.ungdungmuonsachaop.entity.Book;
import com.example.ungdungmuonsachaop.entity.BorrowCode;
import com.example.ungdungmuonsachaop.exception.InvalidBorrowCodeException;
import com.example.ungdungmuonsachaop.exception.OutOfBookException;
import com.example.ungdungmuonsachaop.repository.IBookRepository;
import com.example.ungdungmuonsachaop.repository.IBorrowCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BorrowService implements IBorrowService{
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IBorrowCodeRepository borrowCodeRepository;

    public String borrowBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        if (book.getSoLuong() <= 0){
            throw new OutOfBookException();
        }

        book.setSoLuong(book.getSoLuong() - 1);
        String code = String.format("%05d", new Random().nextInt(100000));
        borrowCodeRepository.save(new BorrowCode(code, book));
        bookRepository.save(book);
        return code;
    }

    public void returnBook(String code) {
        BorrowCode borrowCode = borrowCodeRepository.findById(code).orElseThrow(
                () -> new InvalidBorrowCodeException()
        );

        Book book = borrowCode.getBook();
        book.setSoLuong(book.getSoLuong() + 1);
        bookRepository.save(book);
        borrowCodeRepository.delete(borrowCode);
    }

}
