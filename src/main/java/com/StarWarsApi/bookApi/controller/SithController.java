package com.StarWarsApi.bookApi.controller;

import com.StarWarsApi.bookApi.dto.model.SithDto;
import com.StarWarsApi.bookApi.model.Sith;
import com.StarWarsApi.bookApi.service.SithService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/siths")
public class SithController {

    @Resource(name = "jediService")
    private SithService sithService;

    @GetMapping("/{id}") //Key  GET + /users/id
    public Sith get(@PathVariable long id) {
        return sithService.get(id).orElseThrow(() -> new RuntimeException("Sith not found : " + id));
    }

    @GetMapping //Key GET + /users/
    public List<Sith> getAll() {
        return sithService.getAll();
    }

    @PostMapping // Key POST + /users/
    public Sith create(final @RequestBody SithDto sith){
        return sithService.create(sith).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @PutMapping("/{id}")
    public Sith update(@PathVariable long id, final @RequestBody SithDto userDtoWithUpdate) {
        Optional<Sith> existingUserToUpdate = Optional.ofNullable(sithService.get(id).orElseThrow(() -> new RuntimeException("Sith not found : " + id)));

        return sithService.update(existingUserToUpdate.get(), userDtoWithUpdate)
                .orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return sithService.delete(id);
    }

}
