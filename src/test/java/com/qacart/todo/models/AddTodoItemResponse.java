package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder(setterPrefix = "set")
public class AddTodoItemResponse {
    private String createdAt;
    @JsonProperty("isCompleted")
    private boolean isCompleted;
    private String item;
    private String userID;
    private int __v;
    private String _id;
}
