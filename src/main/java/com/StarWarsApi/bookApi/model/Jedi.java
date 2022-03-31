package com.StarWarsApi.bookApi.model;

import javax.persistence.*;
import java.util.Date;

@Entity // To specify our class as table in DB
@Table(name = "jedis") // To customize table name
public class Jedi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private Date createdAt;

    @Enumerated(EnumType.STRING) // To specify we want get our enum in string
    private GenderType genderType;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "jedi")
    private Planete planete;

    public Jedi(){}

    public Jedi(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public Planete getAddress() {
        return planete;
    }

    public void setAddress(Planete planete) {
        this.planete = planete;
    }
}
