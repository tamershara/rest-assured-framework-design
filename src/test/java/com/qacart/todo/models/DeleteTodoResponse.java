package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder(setterPrefix = "set")
public class DeleteTodoResponse {
    @JsonProperty("isCompleted")
    private boolean isCompleted;
    private String _id;
    private String item;
    private String userID;
    private String createdAt;
    private int __v;
}
