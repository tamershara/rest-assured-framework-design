package com.qacart.todo.testcases;

import com.qacart.todo.models.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qacart.todo.api_steps.TodoSteps.addTodoStep;
import static com.qacart.todo.api_steps.UserSteps.registerUser;
import static com.qacart.todo.clients.TodoClient.deleteTodoAPI;

public class DeleteTodoTest {

    @Test
    void shouldBeAbleToDeleteTodo() {
        //Register using API
        User user = User.builder()
                .setEmail("TestAutomationee83@gmail.com")
                .setFirstName("Test")
                .setLastName("Automation")
                .setPassword("Test1234")
                .build();


        String accessToken = registerUser(user);
        //Add Todo using API
        TodoItem todoItem = TodoItem.builder()
                .setItem("Learn java")
                .setIsCompleted(false).build();

        String todoID = addTodoStep(todoItem,accessToken);
        //Delete TODO
        Response deleteResponse = deleteTodoAPI(todoID,accessToken);

        //Assertion

        DeleteTodoResponse deleteTodoResponse = deleteResponse.as(DeleteTodoResponse.class);
        Assert.assertEquals(deleteResponse.statusCode(),200);
        Assert.assertEquals(deleteTodoResponse.getItem(),"Learn java");
    }
}
