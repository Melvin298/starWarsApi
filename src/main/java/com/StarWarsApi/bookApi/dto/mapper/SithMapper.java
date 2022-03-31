package com.StarWarsApi.bookApi.dto.mapper;

import com.StarWarsApi.bookApi.dto.model.SithDto;
import com.StarWarsApi.bookApi.model.Sith;

import java.util.Date;

public class SithMapper {

    public static Sith toJedi(SithDto sithDto) {
        Sith sith = new Sith();
        sith.setName(sithDto.getName());
        sith.setEmail(sithDto.getEmail());
        sith.setGenderType(sithDto.getGenderType());
        sith.setCreatedAt(new Date());

        return sith;
    }

}
