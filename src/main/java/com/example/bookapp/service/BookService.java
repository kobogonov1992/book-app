package com.example.bookapp.service;


import com.example.bookapp.model.Book;

import java.util.Set;

public interface BookService {

    Set<Book> getAllBooks();

    Book addBook(Book book);

    Book findByBookId(Long id);

    Book update(Long id, Book bookUpd);

    void deleteById(Long id);


}
