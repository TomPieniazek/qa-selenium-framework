package com.tomp.rolnopol.api;

import com.tomp.rolnopol.testdata.RegisterUserData;
import com.tomp.rolnopol.testdata.UserDataFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RegistrationApiTests {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000/";
    }

    @Test
    public void shouldRegisterUser() {
        RegisterUserData user = UserDataFactory.randomUser();
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("email", user.email());
        requestBody.put("password", user.password());
        requestBody.put("displayName", user.displayName());

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/v1/register")
                .then()
                .statusCode(201)
                .body("success", equalTo(true))
                .body("message", equalTo("User registered successfully"))
                .body("data.user.id", greaterThan(0))
                .body("data.user.email", equalTo(user.email()));
    }

    @Test
    public void shouldRegisterUserWithNullOptionalFields() {
        RegisterUserData user = UserDataFactory.randomUserWithoutOptionalFields();
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("email", user.email());
        requestBody.put("password", user.password());
        requestBody.put("displayName", null);

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/v1/register")
                .then()
                .statusCode(201)
                .body("success", equalTo(true))
                .body("message", equalTo("User registered successfully"))
                .body("data.user.id", greaterThan(0))
                .body("data.user.email", equalTo(user.email()));
    }

    @Test
    public void shouldRegisterUserWithoutOptionalFields() {
        RegisterUserData user = UserDataFactory.randomUserWithoutOptionalFields();
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("email", user.email());
        requestBody.put("password", user.password());

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/v1/register")
                .then()
                .statusCode(201)
                .body("success", equalTo(true))
                .body("message", equalTo("User registered successfully"))
                .body("data.user.id", greaterThan(0))
                .body("data.user.email", equalTo(user.email()));
    }

    @Test
    public void shouldRejectRegistrationWhenMandatoryFieldsAreNull() {
        RegisterUserData user = UserDataFactory.randomUser();
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("email", null);
        requestBody.put("password", null);
        requestBody.put("displayName", user.displayName());

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/v1/register")
                .then()
                .statusCode(400)
                .body("success", equalTo(false))
                .body("timestamp", not(blankOrNullString()))
                .body("error", containsString("Email must be in a valid format"))
                .body("error", containsString("Password must be at least 3 characters long"));
    }

    @Test
    public void shouldRejectRegistrationWhenMandatoryFieldsAreNotPresent() {
        RegisterUserData user = UserDataFactory.randomUser();
        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("displayName", user.displayName());

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/v1/register")
                .then()
                .statusCode(400)
                .body("success", equalTo(false))
                .body("timestamp", not(blankOrNullString()))
                .body("error", containsString("Email must be in a valid format"))
                .body("error", containsString("Password must be at least 3 characters long"));
    }
}
