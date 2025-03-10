package com.qacart.todo.models;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set")
@ToString
public class User {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
