package com.qacart.todo.api_steps;

import com.qacart.todo.models.AddTodoItemResponse;
import com.qacart.todo.models.TodoItem;
import io.restassured.response.Response;

import static com.qacart.todo.clients.TodoClient.addTodoAPI;

public final class TodoSteps {

    private TodoSteps(){}
    public static String addTodoStep(TodoItem todoItem,String accessToken)
    {
        Response addTodoResponse = addTodoAPI(todoItem,accessToken);

        //Extract the todoID
        AddTodoItemResponse addTodoItemResponse = addTodoResponse.as(AddTodoItemResponse.class);

        return addTodoItemResponse.get_id();
    }
}
