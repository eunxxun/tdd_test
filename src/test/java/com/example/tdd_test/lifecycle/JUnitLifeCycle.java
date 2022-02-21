package com.example.tdd_test.lifecycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class JUnitLifeCycle {
    private static int counter = 0;

    @BeforeAll
    public static void suiteSetup() {
        System.out.println("suiteSetup");
        assertEquals(0, counter);
        counter++;
    }

    public JUnitLifeCycle() {
        System.out.println("생성자");
        assertTrue(Arrays.asList(1,5).contains(counter));
        counter++;
    }

    @BeforeEach
    public void prepareTest() {
        System.out.println("prepareTest");
        assertTrue(Arrays.asList(2,6).contains(counter));
        counter++;
    }

    @Test
    public void performFirstTest(){
        System.out.println("test1");
        assertTrue(Arrays.asList(3,7).contains(counter));
        counter++;
    }

    @Test
    public void performSecondTest(){
        System.out.println("test2");
        assertTrue(Arrays.asList(3,7).contains(counter));
        counter++;
    }

    @AfterEach
    public void cleanupTest() {
        System.out.println("cleanupTest");
        assertTrue(Arrays.asList(4,8).contains(counter));
        counter++;
    }

    @AfterAll
    public static void suiteFinished() {
        System.out.println("suiteFinished");
        assertEquals(9, counter);
    }
}
