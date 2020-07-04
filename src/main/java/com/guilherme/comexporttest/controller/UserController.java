package com.guilherme.comexporttest.controller;

import com.guilherme.comexporttest.models.User;
import com.guilherme.comexporttest.services.UserService;
import com.guilherme.comexporttest.util.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable(value = "id") long id) {
        Optional<User> pessoa = userService.findById(id);
        return pessoa.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void userInsert(@Valid @RequestBody User user) {
        userService.save(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteById(@PathVariable(value = "id") Long id) {
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value="/name", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findByName(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.descodeParam(text);
        List<User> list  = userService.findByName(text);
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value="/email", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findByEmail(@RequestParam(value = "email", defaultValue = "") String text) {
        text = URL.descodeParam(text);
        List<User> list  = userService.findByEmail(text);
        return ResponseEntity.ok().body(list);
    }
}
