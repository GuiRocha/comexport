package com.guilherme.comexporttest.repositories;

import com.guilherme.comexporttest.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
