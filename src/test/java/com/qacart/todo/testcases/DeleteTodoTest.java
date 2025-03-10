package com.qacart.todo.testcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTodoTest {

    @Test
    void shouldBeAbleToDeleteTodo() {
        //Register using API

        String requestBody = """
                {
                  "email": "testautomation8829908@gmail.com",
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

        //Add Todo using API
        String addTodoRequestBody = """
                {
                    "item": "todo",
                    "isCompleted": false
                }
                """;
        Response addTodoResponse = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .contentType(ContentType.JSON)
                .auth().oauth2(accessToken)
                .body(addTodoRequestBody)
                .when()
                .post("/tasks")
                .then().extract().response();

        //Extract the todoID
        String todoID = addTodoResponse.path("_id");
        //Delete TODO

        Response deleteTodoResponse = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .auth().oauth2(accessToken)
                .pathParam("todoID",todoID)
                .when()
                .delete("/tasks/{todoID}")
                .then().extract().response();

        //Assertion

        Assert.assertEquals(deleteTodoResponse.statusCode(),200);
        Assert.assertEquals(deleteTodoResponse.path("item"),"todo");
    }
}
