package com.example.bookapp.service;


import com.example.bookapp.model.Genre;

import java.util.Set;

public interface GenreService {

    Set<Genre> allGenres();

    Genre addGenre(Genre genre);

    Genre findByGenreId(Long id);

    Genre update(Long id, Genre genreUp);

    void deleteById(Long id);

}
