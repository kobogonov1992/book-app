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
public class GenreController {

    private final GenreService genreService;
    private final BookService bookService;

    @GetMapping("/genres")
    public String allGenres(Model model){
        model.addAttribute("genre",new Genre());
        model.addAttribute("genres",genreService.allGenres());
        return "genreList";
    }

    @GetMapping("/addGenre")
    public String genreForm(Model model){
        model.addAttribute("genre", new Genre());
        Set<Book> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return "addGenre";
    }

    @PostMapping("/addGenre")
    public String addGenre(Genre genre){
        genreService.addGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/updateGenre/{id}")
    public String updateGenreForm(@PathVariable("id") Long id, Model model){
        Genre genre = genreService.findByGenreId(id);
        model.addAttribute("genre",genre);
        return "updateGenre.html";
    }

    @PostMapping("/updateGenre")
    public String updateGenre(Genre genre){
        genreService.addGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("deleteGenre/{id}")
    public String deleteGenre (@PathVariable ("id") Long id ){
        genreService.deleteById(id);
        return "redirect:/genres";
    }

}
