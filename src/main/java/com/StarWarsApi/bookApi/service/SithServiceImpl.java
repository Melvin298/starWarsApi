package com.StarWarsApi.bookApi.service;

import com.StarWarsApi.bookApi.dto.mapper.SithMapper;
import com.StarWarsApi.bookApi.dto.model.SithDto;
import com.StarWarsApi.bookApi.model.Sith;
import com.StarWarsApi.bookApi.repository.SithRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sithService")
public class SithServiceImpl implements SithService {
    @Autowired
    SithRepository sithRepository;

    @Override
    public Optional<Sith> get(long jediId) {
        return sithRepository.findById(sithId);
    }

    @Override
    public List<Sith> getAll() {
        return sithRepository.findAll();
    }

    @Override
    public Optional<Sith> create(SithDto sithDto) {
        return Optional.of( sithRepository.save(SithMapper.toJedi(sithDto)));
    }

    @Override
    public String delete(long sithId) {
        sithRepository.deleteById(sithId);
        return "jedi deleted with success";
    }

    @Override
    public Optional<Sith> update(Sith existingJediToUpdate, SithDto userDtoWithUpdate) {
        // -- Update existing jedi informations
        existingJediToUpdate.setName(userDtoWithUpdate.getName());
        existingJediToUpdate.setEmail(userDtoWithUpdate.getEmail());
        existingJediToUpdate.setGenderType(userDtoWithUpdate.getGenderType());

        // -- Update existing user in DB with new informations
        Optional<Sith> updatedSith = Optional.of(sithRepository.save(existingJediToUpdate));

        return updatedSith;
    }


}
