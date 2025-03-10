package com.qacart.todo.testcases;

import com.qacart.todo.models.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTodoTest {

    @Test
    void shouldBeAbleToDeleteTodo() {
        //Register using API
        User user = User.builder()
                .setEmail("TestAutomation2d790ds3@gmail.com")
                .setFirstName("Test")
                .setLastName("Automation")
                .setPassword("Test1234")
                .build();
        Response registerResponse  = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post("/users/register")
                .then()
                .extract().response();


        //Extract the access token

        UserResponse userResponse = registerResponse.as(UserResponse.class);
        String accessToken = userResponse.getAccess_token();

        //Add Todo using API
        TodoItem todoItem = TodoItem.builder()
                .setItem("Learn java")
                .setIsCompleted(false).build();

        Response addTodoResponse = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .contentType(ContentType.JSON)
                .auth().oauth2(accessToken)
                .body(todoItem)
                .when()
                .post("/tasks")
                .then().extract().response();


        //Extract the todoID
        AddTodoItemResponse addTodoItemResponse = addTodoResponse.as(AddTodoItemResponse.class);

        //Delete TODO
        Response deleteResponse = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .auth().oauth2(accessToken)
                .pathParam("todoID",addTodoItemResponse.get_id())
                .when()
                .delete("/tasks/{todoID}")
                .then().extract().response();

        //Assertion

        DeleteTodoResponse deleteTodoResponse = deleteResponse.as(DeleteTodoResponse.class);
        Assert.assertEquals(deleteResponse.statusCode(),200);
        Assert.assertEquals(deleteTodoResponse.getItem(),"Learn java");
    }
}
