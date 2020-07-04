package com.guilherme.comexporttest.services;


import com.guilherme.comexporttest.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User save(User user);
    Optional<User> findById(Long id);
    void delete(Long id);

    List<User> findByName(String text);

    List<User> findByEmail(String email);


}
