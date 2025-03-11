package com.qacart.todo.clients;

import com.qacart.todo.models.TodoItem;
import io.restassured.response.Response;

import static com.qacart.todo.clients.BaseClients.getRequestAuthentication;

public final class TodoClient {

    private TodoClient(){}
    public static Response addTodoAPI(TodoItem todoItem, String accessToken)
    {
        return getRequestAuthentication(accessToken)
                .body(todoItem)
                .when()
                .post("/tasks");
    }

    public static Response deleteTodoAPI(String todoID, String accessToken)
    {
        return getRequestAuthentication(accessToken)
                .pathParam("todoID",todoID)
                .when()
                .delete("/tasks/{todoID}");
    }
}
