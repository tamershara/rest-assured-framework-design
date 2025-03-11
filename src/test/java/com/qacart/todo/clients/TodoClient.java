package com.qacart.todo.clients;

import com.qacart.todo.models.TodoItem;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public final class TodoClient {

    private TodoClient(){}
    public static Response addTodoAPI(TodoItem todoItem, String accessToken)
    {
        return given()
                .baseUri("https://todo.qacart.com/api/v1")
                .contentType(ContentType.JSON)
                .auth().oauth2(accessToken)
                .body(todoItem)
                .when()
                .post("/tasks")
                .then().extract().response();
    }

    public static Response deleteTodoAPI(String todoID, String accessToken)
    {
        return given()
                .baseUri("https://todo.qacart.com/api/v1")
                .auth().oauth2(accessToken)
                .pathParam("todoID",todoID)
                .when()
                .delete("/tasks/{todoID}")
                .then().extract().response();
    }
}
