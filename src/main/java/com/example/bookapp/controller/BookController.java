package com.example.bookapp.controller;

import com.example.bookapp.model.Book;
import com.example.bookapp.model.Genre;
import com.example.bookapp.service.BookService;
import com.example.bookapp.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Set;


@Controller
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final GenreService genreService;

    @GetMapping("/books")
    public String getAllBookS(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        model.addAttribute("genres",genreService.allGenres());
        return "bookList";
    }

    @GetMapping("/addBook")
    public String createBookForm(Model model){
        model.addAttribute("book",new Book());
        Set<Genre> genres = genreService.allGenres();
        model.addAttribute("genres",genres);
        return "addBook";
    }

    @PostMapping("/addBook") // работает
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/updateBook/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model){
        Book book = bookService.findByBookId(id);
        model.addAttribute("book",book);

        Set<Genre> genres = genreService.allGenres();
        model.addAttribute("genres",genres);
        return "/updateBook";
    }

    @PostMapping("/updateBook")
    public String updateBook(Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable ("id") Long id){
        bookService.deleteById(id);
        return "redirect:/books";
    }

}
