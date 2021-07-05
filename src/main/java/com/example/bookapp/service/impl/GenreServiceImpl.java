package com.example.bookapp.service.impl;

import com.example.bookapp.model.Genre;
import com.example.bookapp.repository.GenreRepo;
import com.example.bookapp.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepo genreRepo;

    @Override
    public Set<Genre> allGenres() {
        Set<Genre> genres = new HashSet<>();
        genreRepo.findAll().iterator().forEachRemaining(genres::add);
        return genres;
    }

    @Override
    public Genre addGenre(Genre genre) {
        return genreRepo.save(genre);
    }

    @Override
    public Genre findByGenreId(Long id) {
        Genre genre = genreRepo.findById(id).orElse(null);
        return genre;
    }

    @Override
    public Genre update(Long id, Genre genreUp) {
        Genre genre = genreRepo.findById(id).orElse(null);
        genre.setName(genreUp.getName());
        genre.setBooks(genreUp.getBooks());
        return genre;
    }

    @Override
    public void deleteById(Long id) {
        genreRepo.deleteById(id);
    }

}
