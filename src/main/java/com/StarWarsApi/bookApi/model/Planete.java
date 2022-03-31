package com.StarWarsApi.bookApi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "planetes")
public class Planete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jedi_id", nullable = false)
    private Jedi jedi;

    public Planete(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Jedi getUser() {
        return jedi;
    }

    public void setUser(Jedi jedi) {
        this.jedi = jedi;
    }
}
