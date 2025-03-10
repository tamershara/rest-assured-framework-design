package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set")
public class TodoItem {
    @JsonProperty("isCompleted")
    private boolean isCompleted;
    private String item;
}
