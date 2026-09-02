package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittensReturnsCountFromFeline() {
        when(feline.getKittens()).thenReturn(2);

        assertEquals(2, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    public void getFoodReturnsFoodFromFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        assertEquals(expectedFood, lion.getFood());
        verify(feline).getFood("Хищник");
    }

    @Test
    public void constructorWithUnknownSexThrowsException() {
        try {
            new Lion("Неизвестный пол", feline);
        } catch (Exception exception) {
            assertEquals(
                    "Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage()
            );
            return;
        }
        throw new AssertionError("Для неизвестного пола ожидалось исключение");
    }
}
