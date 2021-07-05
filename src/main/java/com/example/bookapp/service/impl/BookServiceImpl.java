package com.example.bookapp.service.impl;


import com.example.bookapp.model.Book;
import com.example.bookapp.repository.BookRepo;
import com.example.bookapp.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;


@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public Set<Book> getAllBooks() {
        Set<Book> books = new HashSet<>();
        bookRepo.findAll().iterator().forEachRemaining(books::add);
        return books;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book findByBookId(Long id) {
        Book book = bookRepo.findById(id).orElse(null);
        return book;
    }

    @Override
    public Book update(Long id, Book bookUpd) {
        Book book = bookRepo.findById(id).orElse(null);
        book.setTitle(bookUpd.getTitle());
        book.setAuthor(bookUpd.getAuthor());
        book.setGenres(bookUpd.getGenres());
        return book;
    }

    @Override
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }


}
