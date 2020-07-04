package com.guilherme.comexporttest.services;


import com.guilherme.comexporttest.models.User;
import com.guilherme.comexporttest.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void shouldFindAll() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        when(userRepository.findAll()).thenReturn(Stream.of(new User(1L, "teste", "test@test.com", simpleDateFormat.parse("21/03/2018"), "rua 12")).collect(Collectors.toList()));
        assertEquals(1, userService.findAll().size());
    }


    @Test
    public void shouldFindById() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        User user =new User(1L, "teste", "test@test.com", simpleDateFormat.parse("21/03/2018"), "rua 12");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    }
    @Test
    void createShouldPersistData() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        User user = new User(5L, "teste", "test@test.com", simpleDateFormat.parse("26/06/1998"), "rua 12");
        this.userRepository.save(user);
        assertThat(user.getId()).isEqualTo(5L);
        assertThat(user.getName()).isEqualTo("teste");
        assertThat(user.getEmail()).isEqualTo("test@test.com");
        assertThat(user.getAddress()).isEqualTo("rua 12");
        assertThat(user.getBirthDate()).isEqualTo("1998-06-26T00:00:00.000+00:00");
    }
    @Test
    void deleteShouldRemoveData() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        User user = new User(5L, "teste", "test@test.com", simpleDateFormat.parse("26/06/1998"), "rua 12");

        this.userRepository.save(user);
        userRepository.delete(user);
        assertThat(userRepository.findById(user.getId())).isEmpty();
    }
}