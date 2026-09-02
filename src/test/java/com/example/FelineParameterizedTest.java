package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters(name = "котят: {0}")
    public static Object[][] kittensCounts() {
        return new Object[][]{{0}, {1}, {3}};
    }

    @Test
    public void getKittensWithCountReturnsGivenCount() {
        assertEquals(kittensCount, new Feline().getKittens(kittensCount));
    }
}
