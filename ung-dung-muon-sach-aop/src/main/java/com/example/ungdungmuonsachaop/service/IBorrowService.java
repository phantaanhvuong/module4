package com.example.ungdungmuonsachaop.service;

public interface IBorrowService {
    String borrowBook(Long bookId);
    void returnBook(String maSach);

}
