package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    public void getFoodForHerbivoreReturnsPlants() throws Exception {
        assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
    }

    @Test
    public void getFoodForPredatorReturnsAnimalFood() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), animal.getFood("Хищник"));
    }

    @Test
    public void getFoodForUnknownKindThrowsException() {
        try {
            animal.getFood("Всеядное");
        } catch (Exception exception) {
            assertEquals(
                    "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    exception.getMessage()
            );
            return;
        }
        throw new AssertionError("Для неизвестного вида ожидалось исключение");
    }

    @Test
    public void getFamilyReturnsAnimalFamilies() {
        assertEquals(
                "Существует несколько семейств: заячьи, беличьи, мышиные, "
                        + "кошачьи, псовые, медвежьи, куньи",
                animal.getFamily()
        );
    }
}
