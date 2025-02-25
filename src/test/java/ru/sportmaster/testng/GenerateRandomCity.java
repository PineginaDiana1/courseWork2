package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class GenerateRandomCity {
    @Test
    @Step("Проверка списка выживших в пустом городе")
    public void testGenerateRandomCity_EmptyCity() {
        City city = DataGenerator.generateRandomCity("Empty City", 0);

        Assertions.assertThat(city)
                .as("Проверка генерации города без выживших")
                .isNotNull();
        Assertions.assertThat(city.getSurvivors())
                .isEmpty();
    }

    @Test
    @Step("Проверка списка выживших в городе с одним выжившим")
    public void testGenerateRandomCity_SingleSurvivor() {
        City city = DataGenerator.generateRandomCity("Single Survivor City", 1);

        Assertions.assertThat(city)
                .as("Проверка генерации города с одним выжившим")
                .isNotNull();
        Assertions.assertThat(city.getSurvivors())
                .hasSize(1);
    }

    @Test
    @Step("Проверка списка выживших в городе с несколькими выжившими")
    public void testGenerateRandomCity_MultipleSurvivors() {

        City city = DataGenerator.generateRandomCity("Multiple Survivors City", 5);

        Assertions.assertThat(city)
                .as("Проверка генерации города с несколькими выжившими")
                .isNotNull();
        Assertions.assertThat(city.getSurvivors())
                .hasSize(5);
    }


    @Test
    @Step("Проверка корректности выживших в городе")
    public void testGenerateRandomCity_SurvivorsAreValid() {

        City city = DataGenerator.generateRandomCity("Survivors City", 3);

        List<Survivor> survivors = city.getSurvivors();
        Assertions.assertThat(survivors)
                .hasSize(3)
                .allSatisfy(survivor -> {
                    Assertions.assertThat(survivor.getName())
                            .as("Проверка имени выжившего")
                            .isNotBlank();
                    Assertions.assertThat(survivor.getAge())
                            .as("Проверка возраста выжившего")
                            .isBetween(0, 120);
                    Assertions.assertThat(survivor)
                            .as("Проверка роли выжившего")
                            .isInstanceOfAny(Medic.class, Worker.class, Soldier.class);
                });
    }
}

