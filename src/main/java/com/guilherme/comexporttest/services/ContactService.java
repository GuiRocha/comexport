package com.guilherme.comexporttest.services;

import com.guilherme.comexporttest.models.Contact;
import com.guilherme.comexporttest.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository categoryRepository;

    public List<Contact> findAll() {
        return categoryRepository.findAll();
    }
    public Contact findById(Long id){
        Optional<Contact> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
