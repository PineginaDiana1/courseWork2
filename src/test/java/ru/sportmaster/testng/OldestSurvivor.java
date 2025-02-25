package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OldestSurvivor {
    private City city;
    @BeforeMethod
    void setUp() {
        city = new City("Test City");
    }

    @Test
    @Step("Проверка получения пустого результата")
    public void checkOldestSurvivorEmptyList() {
        Survivor survivor = city.getOldestSurvivor();

        Assertions.assertThat(survivor)
                .isNull();
    }

    @Test
    @Step("Проверка получения страшего выжившего из одного выжившего")
    public void checkOldestSurvivorSingleSurvivor() {

        Survivor survivor = new Worker("Alex Russo", 3);
        city.addSurvivor(survivor);

        Survivor oldest = city.getOldestSurvivor();

        Assertions.assertThat(oldest)
                .isEqualTo(survivor);
    }

    @DataProvider(name = "survivorData")
    public Object[][] survivorData() {
        return new Object[][]{
                // Набор данных 1: Самый cтарый - Alex Russo (39 года)
                {
                        new Survivor[]{new Worker("Alex Russo", 39), new Medic("John Doe", 5), new Soldier("John Snow", 30)},
                        new Worker("Alex Russo", 39)
                },
                // Набор данных 2: Самый старый - Jane Smith (100 лет)
                {
                        new Survivor[]{new Medic("Jane Smith", 100), new Worker("Bob Johnson", 20), new Soldier("Alice Brown", 15)},
                        new Medic("Jane Smith", 100)
                },
                // Набор данных 3: Самый старый - Baby (100 лет)
                {
                        new Survivor[]{new Worker("Baby", 100), new Medic("John Doe", 5), new Soldier("John Snow", 30)},
                        new Worker("Baby", 100)
                },
                // Набор данных 4: Все выжившие одного возраста
                {
                        new Survivor[]{new Worker("Alex Russo", 25), new Medic("John Doe", 25), new Soldier("John Snow", 25)},
                        new Worker("Alex Russo", 25) // Возвращается первый из списка
                }
        };
    }

    @Test(dataProvider = "survivorData")
    @Step("Проверка получения старшего выжившего из списка")
    public void checkOldestSurvivor(Survivor[] survivors, Survivor expectedOldest) {

        for (Survivor survivor : survivors) {
            city.addSurvivor(survivor);
        }

        Survivor oldest = city.getOldestSurvivor();

        Assertions.assertThat(oldest)
                .usingRecursiveComparison()
                .isEqualTo(expectedOldest);

    }
}
