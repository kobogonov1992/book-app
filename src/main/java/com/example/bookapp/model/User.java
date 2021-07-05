package com.example.bookapp.model;

import com.example.bookapp.model.base.BaseId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseId {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

//    @OneToMany(
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private Set<Book> userBooks = new HashSet<>();
//
//    @OneToMany(
//            mappedBy = "user",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private Set<Genre> userGenres = new HashSet<>();

}
