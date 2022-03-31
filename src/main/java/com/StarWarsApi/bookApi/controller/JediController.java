package com.StarWarsApi.bookApi.controller;

import com.StarWarsApi.bookApi.dto.model.UserDto;
import com.StarWarsApi.bookApi.model.Jedi;
import com.StarWarsApi.bookApi.service.JediService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jedis")
public class JediController {

    @Resource(name = "jediService")
    private JediService jediService;

    @GetMapping("/{id}") //Key  GET + /users/id
    public Jedi get(@PathVariable long id) {
        return jediService.get(id).orElseThrow(() -> new RuntimeException("Jedi not found : " + id));
    }

    @GetMapping //Key GET + /users/
    public List<Jedi> getAll() {
        return jediService.getAll();
    }

    @PostMapping // Key POST + /users/
    public Jedi create(final @RequestBody UserDto jedi){
        return jediService.create(jedi).orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @PutMapping("/{id}")
    public Jedi update(@PathVariable long id, final @RequestBody UserDto userDtoWithUpdate) {
        Optional<Jedi> existingUserToUpdate = Optional.ofNullable(jediService.get(id).orElseThrow(() -> new RuntimeException("Jedi not found : " + id)));

        return jediService.update(existingUserToUpdate.get(), userDtoWithUpdate)
                .orElseThrow(() -> new RuntimeException("Something went wrong, please try later"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return jediService.delete(id);
    }

}
