package com.guilherme.comexporttest.controller;

import com.guilherme.comexporttest.models.User;
import com.guilherme.comexporttest.services.UserService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.springframework.http.ResponseEntity;


@WebMvcTest
public class UserControllerTest {


    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.userController);
    }
    @Test
    public void ShouldReturnSuccess_FindById() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        when(this.userService.findById(1L))
                .thenReturn(java.util.Optional.of(new User(1L, "teste", "test@test.com", simpleDateFormat.parse("21/03/2018"), "rua 12")));
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/users/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }
    @Test
    public void shouldReturnNotFound_FindById() {
        when(this.userService.findById(5L))
                .thenReturn(null);
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/users/{id}", 5L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
    @Test
    public void shouldReturnBadRequest_FindById() {

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/users/{id}", 1L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
                verify(this.userService, never()).findById(1L);
    }
}