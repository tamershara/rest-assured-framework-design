package com.qacart.todo.fixures;


import com.qacart.todo.models.TodoItem;

public final class TodoFixture {
    private TodoFixture(){}

    public static TodoItem createDefaultTodo (){
        return TodoItem.builder()
                .setItem("Learn java")
                .setIsCompleted(false).build();
    }
}
