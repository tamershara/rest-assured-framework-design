package com.qacart.todo.utills;

import java.time.Instant;

public final class TestDataUtils {
    private TestDataUtils() {}

    public static String getRandomEmail() {
        long currentTimeStamp = Instant.now().toEpochMilli();
        return "TestAutomation" + currentTimeStamp + "@gmail.com";
    }
}
