package com.StarWarsApi.bookApi.service;

import com.StarWarsApi.bookApi.model.Jedi;
import com.StarWarsApi.bookApi.model.Planete;
import com.StarWarsApi.bookApi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("planeteService")
public class PlaneteServiceImpl implements PlaneteService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Optional<Planete> get(long addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public List<Planete> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Planete> create(String name, Jedi addressOwner) {

        Optional<Planete> addressExistWithOwnerId = getByOwnerId(addressOwner.getId());

        if (addressExistWithOwnerId.isPresent()){
            addressExistWithOwnerId.get().setName(name);

            return Optional.of(addressRepository.save(addressExistWithOwnerId.get()));
        }

        Planete planete = new Planete();
        planete.setName(name);
        planete.setUser(addressOwner);

        return Optional.of(addressRepository.save(planete));
    }

    @Override
    public Optional<Planete> getByOwnerId(long addressOwnerId) {
        return addressRepository.findByUserId(addressOwnerId);
    }

}
