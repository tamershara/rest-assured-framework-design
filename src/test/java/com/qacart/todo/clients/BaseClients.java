package com.qacart.todo.clients;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class BaseClients {
    private BaseClients() {}

    public static RequestSpecification getRequestSpecification() {
        return given()
                .baseUri("https://todo.qacart.com/api/v1")
                .contentType(ContentType.JSON);
    }

    public static RequestSpecification getRequestAuthentication(String accessToken) {
        return getRequestSpecification()
                .auth().oauth2(accessToken);
    }
}
