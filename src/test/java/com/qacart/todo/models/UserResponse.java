package com.qacart.todo.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private String access_token;
    private String firstName;
    private String userID;
}
