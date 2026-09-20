package com.api.demo.serviceobjects;

import io.restassured.RestAssured;

public class RefServiceObjects {

    public RefServiceObjects(int port) {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    public String ex1() {
        return RestAssured
                .given()
                .when()
                .get("/ex1")
                .then()
                .statusCode(200)
                .extract()
                .asString();
    }

   


}
