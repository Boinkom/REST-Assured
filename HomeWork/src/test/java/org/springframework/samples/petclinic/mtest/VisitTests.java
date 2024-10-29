package com.example.petclinic;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class VisitTests extends BaseTest {

    @Test
    public void createVisit_PositiveScenario() {
        int ownerId = 1;
        int petId = 1;
        String date = "2024-11-01";
        String description = "Surgery vet1";


        given()
            .contentType(ContentType.JSON)
            .body("{ \"date\": \"" + date + "\", \"description\": \"" + description + "\" }")
            .when()
            .post("/owners/" + ownerId + "/pets/" + petId + "/visits")
            .then()
            .statusCode(201);


        given()
            .when()
            .get("/owners/" + ownerId + "/pets/" + petId + "/visits")
            .then()
            .statusCode(200)
            .body("description", hasItem(description))
            .body("date", hasItem(date));
    }

    @Test
    public void getVisit_NonExistingPet_NegativeScenario() {
        int nonExistentPetId = 999;

        given()
            .when()
            .get("/owners/1/pets/" + nonExistentPetId + "/visits")
            .then()
            .statusCode(404);
    }
}
