package com.openobject.openDashBoardServer.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.openobject.openDashBoardServer.service.BackendServiceTest;

public class BackendControllerTest {

    @DisplayName("Test MessageService.get()")
    @Test
    void testGet() {
        assertEquals("Hello JUnit 5", BackendServiceTest.get());
    }

}
