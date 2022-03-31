package com.StarWarsApi.bookApi.controller;

import com.StarWarsApi.bookApi.dto.model.AddressDto;
import com.StarWarsApi.bookApi.model.Planete;
import com.StarWarsApi.bookApi.model.Jedi;
import com.StarWarsApi.bookApi.service.PlaneteService;
import com.StarWarsApi.bookApi.service.JediService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/planetes")
public class PlaneteController {

    @Resource(name = "planeteService")
    private PlaneteService planeteService;

    @Resource(name = "jediService")
    private JediService jediService;

    @GetMapping("/{id}")
    public Planete get(@PathVariable long id) {
        return planeteService.get(id).orElseThrow(() -> new RuntimeException("Planete not found : " + id));
    }

    @GetMapping
    public List<Planete> getAll() {
        return planeteService.getAll();
    }

    @PostMapping
    public Planete create(final @RequestBody AddressDto addressDto){
        Jedi addressOwner = jediService.get(addressDto.getAddressOwnerId()).orElseThrow(() -> new RuntimeException("Jedi not found : " + addressDto.getAddressOwnerId()));

        return planeteService.create(addressDto.getName(), addressOwner).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }
}
