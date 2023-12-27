package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private static final int KITTEN_COUNT = 1;
    private  static final int KITTEN_COUNT_2 = 5;

    @Spy
    private Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyMeat() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();

        assertEquals("Семейство: ОР != ФР", "Кошачьи", actual);
    }

    @Test
    public void getKittensTest() {
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(KITTEN_COUNT);

        assertEquals("Количество котят: ОР != ФР", KITTEN_COUNT, actual);
    }

    @Test
    public void getKittensTest2() {
        int actual = feline.getKittens(KITTEN_COUNT_2);
        Mockito.verify(feline).getKittens(Mockito.anyInt());

        assertEquals("Количество котят: ОР != ФР", KITTEN_COUNT_2, actual);
    }

}
