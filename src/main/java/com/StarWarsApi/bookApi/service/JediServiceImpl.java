package com.StarWarsApi.bookApi.service;

import com.StarWarsApi.bookApi.dto.mapper.JediMapper;
import com.StarWarsApi.bookApi.dto.model.UserDto;
import com.StarWarsApi.bookApi.repository.UserRepository;
import com.StarWarsApi.bookApi.model.Jedi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("jediService")
public class JediServiceImpl implements JediService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<Jedi> get(long jediId) {
        return userRepository.findById(jediId);
    }

    @Override
    public List<Jedi> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Jedi> create(UserDto userDto) {
        return Optional.of( userRepository.save(JediMapper.toJedi(userDto)));
    }

    @Override
    public String delete(long jediId) {
        userRepository.deleteById(jediId);
        return "jedi deleted with success";
    }

    @Override
    public Optional<Jedi> update(Jedi existingJediToUpdate, UserDto userDtoWithUpdate) {
        // -- Update existing jedi informations
        existingJediToUpdate.setName(userDtoWithUpdate.getName());
        existingJediToUpdate.setEmail(userDtoWithUpdate.getEmail());
        existingJediToUpdate.setGenderType(userDtoWithUpdate.getGenderType());

        // -- Update existing user in DB with new informations
        Optional<Jedi> updatedJedi = Optional.of(userRepository.save(existingJediToUpdate));

        return updatedJedi;
    }


}
