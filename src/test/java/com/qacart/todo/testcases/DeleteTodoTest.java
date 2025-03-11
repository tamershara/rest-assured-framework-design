package com.qacart.todo.testcases;

import com.qacart.todo.models.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qacart.todo.clients.TodoClient.addTodoAPI;
import static com.qacart.todo.clients.TodoClient.deleteTodoAPI;
import static com.qacart.todo.clients.UserClient.registerAPI;

public class DeleteTodoTest {

    @Test
    void shouldBeAbleToDeleteTodo() {
        //Register using API
        User user = User.builder()
                .setEmail("TestAutomation2d790dsiu93@gmail.com")
                .setFirstName("Test")
                .setLastName("Automation")
                .setPassword("Test1234")
                .build();
        Response registerResponse  = registerAPI(user);


        //Extract the access token

        UserResponse userResponse = registerResponse.as(UserResponse.class);
        String accessToken = userResponse.getAccess_token();

        //Add Todo using API
        TodoItem todoItem = TodoItem.builder()
                .setItem("Learn java")
                .setIsCompleted(false).build();

        Response addTodoResponse = addTodoAPI(todoItem,accessToken);

        //Extract the todoID
        AddTodoItemResponse addTodoItemResponse = addTodoResponse.as(AddTodoItemResponse.class);

        //Delete TODO
        Response deleteResponse = deleteTodoAPI(addTodoItemResponse.get_id(),accessToken);

        //Assertion

        DeleteTodoResponse deleteTodoResponse = deleteResponse.as(DeleteTodoResponse.class);
        Assert.assertEquals(deleteResponse.statusCode(),200);
        Assert.assertEquals(deleteTodoResponse.getItem(),"Learn java");
    }
}
