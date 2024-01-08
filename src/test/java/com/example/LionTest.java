package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;



@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;
    @Mock
    private Feline feline;


    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }
    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        lion = new Lion("Самка", feline);

        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeExceptionTest() {
        Throwable throwable = catchThrowable(() -> {
            lion = new Lion("Оно", feline);
            lion = new Lion("Самка", feline);

        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage("Используйте допустимые значения пола животного - самец или самка");
    }

    @Test
    public void getFoodTest() throws Exception {

        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}
