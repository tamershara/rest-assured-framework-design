package com.qacart.todo.testcases;

import com.qacart.todo.models.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qacart.todo.api_steps.TodoSteps.addTodoStep;
import static com.qacart.todo.api_steps.UserSteps.registerUser;
import static com.qacart.todo.clients.TodoClient.deleteTodoAPI;
import static com.qacart.todo.fixures.TodoFixture.createDefaultTodo;
import static com.qacart.todo.fixures.UserFixtures.createDefaultUser;
import static com.qacart.todo.utills.TestDataUtils.getRandomEmail;

public class DeleteTodoTest {

    @Test
    void shouldBeAbleToDeleteTodo() {
        //Register user
        String accessToken = registerUser(createDefaultUser());
        //Add Todo using API
        TodoItem todoItem = createDefaultTodo();
        String todoID = addTodoStep(todoItem,accessToken);
        //Delete TODO
        Response deleteResponse = deleteTodoAPI(todoID,accessToken);
        //Assertion
        DeleteTodoResponse deleteTodoResponse = deleteResponse.as(DeleteTodoResponse.class);
        Assert.assertEquals(deleteResponse.statusCode(),200);
        Assert.assertEquals(deleteTodoResponse.getItem(),"Learn java");
    }
}
