package com.qacart.todo.clients;

import com.qacart.todo.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static com.qacart.todo.clients.BaseClients.getRequestSpecification;

public final class UserClient {
    private UserClient(){}
    public static Response registerAPI(User user){
        return getRequestSpecification()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post("/users/register")
                .then()
                .extract().response();
    }
}
