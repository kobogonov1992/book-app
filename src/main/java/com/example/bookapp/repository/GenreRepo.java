package com.example.bookapp.repository;

import com.example.bookapp.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {


}
