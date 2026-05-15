package com.tomp.rolnopol.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class HomeApiTests {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000/";
    }

    @Test
    public void shouldReturnStatisticsSmoke() {
        given()
                .when()
                .get("/api/v1/statistics")
                .then()
                .statusCode(200)
                .body("users", isA(Integer.class));
    }

    @Test
    public void shouldReturnStatisticsSchemaValidation() {
        given()
                .when()
                .get("/api/v1/statistics")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/statistics-schema.json"));
    }
}
