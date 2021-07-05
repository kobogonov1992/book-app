package com.example.bookapp.model;


import com.example.bookapp.model.base.BaseId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseId {

    @NotNull
    private String title;

    @NotNull
    private String author;

    @ManyToMany
    @JoinTable(name = "genres_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn (name="genre_id"))
    private Set<Genre> genres = new HashSet<>();

//    @ManyToOne
//    private User user;
}
