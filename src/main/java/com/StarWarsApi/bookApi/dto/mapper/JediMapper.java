package com.StarWarsApi.bookApi.dto.mapper;

import com.StarWarsApi.bookApi.dto.model.UserDto;
import com.StarWarsApi.bookApi.model.Jedi;

import java.util.Date;

public class JediMapper {

    public static Jedi toJedi(UserDto userDto) {
        Jedi jedi = new Jedi();
        jedi.setName(userDto.getName());
        jedi.setEmail(userDto.getEmail());
        jedi.setGenderType(userDto.getGenderType());
        jedi.setCreatedAt(new Date());

        return jedi;
    }

}
