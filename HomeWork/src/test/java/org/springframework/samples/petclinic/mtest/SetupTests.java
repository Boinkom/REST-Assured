package com.example.petclinic;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SetupTests extends BaseTest {

    @Test
    public void addAdminUser() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"username\": \"admin\", \"role\": \"admin\" }")
            .when()
            .post("/users")
            .then()
            .statusCode(201);
    }

    @Test
    public void addOwners() {
        // Добавление первого владельца
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Owner 1\", \"address\": \"123 Street\", \"city\": \"City1\", \"telephone\": \"1234567890\" }")
            .when()
            .post("/owners")
            .then()
            .statusCode(201);

        // Добавление второго владельца
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Owner 2\", \"address\": \"456 Avenue\", \"city\": \"City2\", \"telephone\": \"0987654321\" }")
            .when()
            .post("/owners")
            .then()
            .statusCode(201);
    }

    @Test
    public void addPetTypes() {
        // Добавление типа питомца Dog
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Dog\" }")
            .when()
            .post("/pettypes")
            .then()
            .statusCode(201);

        // Добавление типа питомца Cat
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Cat\" }")
            .when()
            .post("/pettypes")
            .then()
            .statusCode(201);

        // Добавление типа питомца Bird
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Bird\" }")
            .when()
            .post("/pettypes")
            .then()
            .statusCode(201);
    }

    @Test
    public void addPets() {
        // Добавление питомцев для первого владельца
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Buddy\", \"birthDate\": \"2020-01-01\", \"type\": {\"id\": 1, \"name\": \"Dog\"}, \"owner\": {\"id\": 1} }")
            .when()
            .post("/pets")
            .then()
            .statusCode(201);

        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Max\", \"birthDate\": \"2021-03-15\", \"type\": {\"id\": 2, \"name\": \"Cat\"}, \"owner\": {\"id\": 1} }")
            .when()
            .post("/pets")
            .then()
            .statusCode(201);

        // Добавление питомцев для второго владельца
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Bella\", \"birthDate\": \"2022-06-10\", \"type\": {\"id\": 1, \"name\": \"Dog\"}, \"owner\": {\"id\": 2} }")
            .when()
            .post("/pets")
            .then()
            .statusCode(201);

        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Charlie\", \"birthDate\": \"2021-11-25\", \"type\": {\"id\": 3, \"name\": \"Bird\"}, \"owner\": {\"id\": 2} }")
            .when()
            .post("/pets")
            .then()
            .statusCode(201);

        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Luna\", \"birthDate\": \"2020-08-20\", \"type\": {\"id\": 2, \"name\": \"Cat\"}, \"owner\": {\"id\": 2} }")
            .when()
            .post("/pets")
            .then()
            .statusCode(201);
    }

    @Test
    public void addVetSpecialties() {
        // Добавление специализации "Surgery"
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Surgery\" }")
            .when()
            .post("/specialties")
            .then()
            .statusCode(201);

        // Добавление специализации "Dentistry"
        given()
            .contentType(ContentType.JSON)
            .body("{ \"name\": \"Dentistry\" }")
            .when()
            .post("/specialties")
            .then()
            .statusCode(201);
    }

    @Test
    public void addVets() {
        // Ветеринар с специализацией Surgery
        given()
            .contentType(ContentType.JSON)
            .body("{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"specialties\": [{\"id\": 1, \"name\": \"Surgery\"}] }")
            .when()
            .post("/vets")
            .then()
            .statusCode(201);

        // Ветеринар с специализацией Dentistry
        given()
            .contentType(ContentType.JSON)
            .body("{ \"firstName\": \"Jane\", \"lastName\": \"Smith\", \"specialties\": [{\"id\": 2, \"name\": \"Dentistry\"}] }")
            .when()
            .post("/vets")
            .then()
            .statusCode(201);

        // Ветеринар с обеими специализациями
        given()
            .contentType(ContentType.JSON)
            .body("{ \"firstName\": \"Alice\", \"lastName\": \"Johnson\", \"specialties\": [{\"id\": 1, \"name\": \"Surgery\"}, {\"id\": 2, \"name\": \"Dentistry\"}] }")
            .when()
            .post("/vets")
            .then()
            .statusCode(201);
    }
}
