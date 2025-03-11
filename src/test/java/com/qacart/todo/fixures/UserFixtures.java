package com.qacart.todo.fixures;

import com.qacart.todo.models.User;

import static com.qacart.todo.utills.TestDataUtils.getRandomEmail;

public final class UserFixtures {

    private UserFixtures() {}

    public static User createDefaultUser() {
        return User.builder()
                .setEmail(getRandomEmail())
                .setFirstName("Test")
                .setLastName("Automation")
                .setPassword("Test1234")
                .build();
    }
}
