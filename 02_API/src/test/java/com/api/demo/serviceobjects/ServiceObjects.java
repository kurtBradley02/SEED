package com.api.demo.serviceobjects;

import io.restassured.RestAssured;

public class ServiceObjects {

    public ServiceObjects(int port) {
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

    public int ex2(int a, int b) {
        return RestAssured
                .given()
                .queryParam("a", a)
                .queryParam("b", b)
                .when()
                .get("/ex2")
                .then()
                .statusCode(200)
                .extract()
                .as(Integer.class);
    }

    public String[] ex3(int a, int b) {
        return RestAssured
                .given()
                .queryParam("a", a)
                .queryParam("b", b)
                .when()
                .get("/ex3")
                .then()
                .statusCode(200)
                .extract()
                .as(String[].class);
    }

    public String ex4(int a) {
        return RestAssured
                .given()
                .queryParam("a", a)
                .when()
                .get("/ex4")
                .then()
                .statusCode(200)
                .extract()
                .asString();
    }

}
