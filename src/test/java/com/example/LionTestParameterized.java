package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParameterized {

    private final String sex;
    private final boolean expected;
    @Mock
    private Feline feline;

    public LionTestParameterized(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void createLionMaleTest() throws Exception {
            Lion lion = new Lion(sex, feline);
            assertEquals(expected, lion.doesHaveMane());
    }
}
