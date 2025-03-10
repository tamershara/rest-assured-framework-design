package com.qacart.todo.testcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTodoTest {

    @Test
    void shouldBeAbleToDeleteTodo() {
        //Register using API

        String requestBody = """
                {
                  "email": "testautomation28@gmail.com",
                  "password": "test1234",
                  "firstName": "Test",
                  "lastName": "automation"
                }
                """;
        Response registerResponse  = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .body(requestBody)
                .contentType(ContentType.JSON)
                .when()
                .post("/users/register")
                .then()
                .extract().response();

        //Extract the access token
        String accessToken = registerResponse.path("access_token");
        System.out.println(accessToken);

        //Add Todo using API
        String addTodoRequestBody = """
                {
                    "item": "todo",
                    "isCompleted": false
                }
                """;
        given()
                .baseUri("https://todo.qacart.com/api/v1")
                .contentType(ContentType.JSON)
                .body(addTodoRequestBody)
                .when()
                .post("/tasks")
                .then().log().all();

        //Extract the todoID

        //Delete TODO
        given()
                .baseUri("https://todo.qacart.com/api/v1")
                .pathParam("todoID","67cf348da5d62b001423624d")
                .when()
                .delete("/tasks/{id}")
                .then().log().all();

        //Assertion
    }
}
