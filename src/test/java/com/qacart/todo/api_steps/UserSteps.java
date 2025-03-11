package com.qacart.todo.api_steps;

import com.qacart.todo.models.User;
import com.qacart.todo.models.UserResponse;
import io.restassured.response.Response;

import static com.qacart.todo.clients.UserClient.registerAPI;

public final class UserSteps {
    private UserSteps(){}
    public static String registerUser(User user) {
        Response registerResponse  = registerAPI(user);
        //Extract the access token
        UserResponse userResponse = registerResponse.as(UserResponse.class);
        return userResponse.getAccess_token();

    }
}
