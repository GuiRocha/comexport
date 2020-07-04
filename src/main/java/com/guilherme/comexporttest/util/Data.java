package com.guilherme.comexporttest.util;

import com.guilherme.comexporttest.models.Contact;
import com.guilherme.comexporttest.models.User;
import com.guilherme.comexporttest.repositories.ContactRepository;
import com.guilherme.comexporttest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Data implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        contactRepository.deleteAll();

        Contact contact1 = new Contact(null, "teste", "teste");
        contactRepository.saveAll(Arrays.asList(contact1));

        User user1 = new User(null, "teste", "test@test.com", simpleDateFormat.parse("26/06/1998"),  "rua 12");
        userRepository.saveAll(Arrays.asList(user1));
        user1.getContacts().add(contact1);
        userRepository.saveAll(Arrays.asList(user1));
    }
}
