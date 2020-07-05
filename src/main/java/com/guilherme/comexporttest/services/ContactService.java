package com.guilherme.comexporttest.services;

import com.guilherme.comexporttest.models.Contact;
import com.guilherme.comexporttest.models.User;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAll();

    Optional<Contact> findById(Long id);

    Contact save(Contact contact);


    void delete(Long id);
}
