package com.qacart.todo.clients;

import com.qacart.todo.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public final class UserClient {
    private UserClient(){}
    public static Response registerAPI(User user){
        return given()
                .baseUri("https://todo.qacart.com/api/v1")
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post("/users/register")
                .then()
                .extract().response();
    }
}
