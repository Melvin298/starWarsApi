package com.StarWarsApi.bookApi.dto.model;

import com.StarWarsApi.bookApi.model.GenderType;

public class SithDto {

    private String name;

    private String email;

    private GenderType genderType;

    public SithDto(String name, String email, GenderType genderType) {
        this.name = name;
        this.email = email;
        this.genderType = genderType;
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

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }
}
