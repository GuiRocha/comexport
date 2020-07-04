package com.guilherme.comexporttest.services;

import com.guilherme.comexporttest.models.User;
import com.guilherme.comexporttest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional <User> findById(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public User save(User user) {
        user.setChangeDate(LocalDateTime.now());
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<User> findByName(String text) {
        return userRepository.findByName(text);
    }
    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
