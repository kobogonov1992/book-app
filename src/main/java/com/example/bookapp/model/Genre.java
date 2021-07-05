package com.example.bookapp.model;

import com.example.bookapp.model.base.BaseId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Genre extends BaseId {

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

//    @ManyToOne
//    private User user;
}
