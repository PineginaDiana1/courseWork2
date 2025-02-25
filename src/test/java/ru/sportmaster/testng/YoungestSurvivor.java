package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YoungestSurvivor {
    private City city;
    @BeforeMethod
    void setUp() {
        city = new City("Test City");
    }

    @Test
    @Step("Проверка получения пустого результата")
    public void checkYoungestSurvivorEmptyList() {
        Survivor survivor = city.getYoungestSurvivor();

        Assertions.assertThat(survivor)
                .isNull();
    }

    @Test
    @Step("Проверка получения младшего выжившего из одного выжившего")
    public void checkYoungestSurvivorSingleSurvivor() {

        Survivor survivor = new Worker("Alex Russo", 3);
        city.addSurvivor(survivor);

        Survivor youngest = city.getYoungestSurvivor();

        Assertions.assertThat(youngest)
                .isEqualTo(survivor);
    }

    @DataProvider(name = "survivorData")
    public Object[][] survivorData() {
        return new Object[][]{
                // Набор данных 1: Самый молодой - Alex Russo (3 года)
                {
                        new Survivor[]{new Worker("Alex Russo", 3), new Medic("John Doe", 5), new Soldier("John Snow", 30)},
                        new Worker("Alex Russo", 3)
                },
                // Набор данных 2: Самый молодой - Jane Smith (10 лет)
                {
                        new Survivor[]{new Medic("Jane Smith", 10), new Worker("Bob Johnson", 20), new Soldier("Alice Brown", 15)},
                        new Medic("Jane Smith", 10)
                },
                // Набор данных 3: Самый молодой - Baby (0 лет)
                {
                        new Survivor[]{new Worker("Baby", 0), new Medic("John Doe", 5), new Soldier("John Snow", 30)},
                        new Worker("Baby", 0)
                },
                // Набор данных 4: Все выжившие одного возраста
                {
                        new Survivor[]{new Worker("Alex Russo", 25), new Medic("John Doe", 25), new Soldier("John Snow", 25)},
                        new Worker("Alex Russo", 25) // Возвращается первый из списка
                }
        };
    }

    @Test(dataProvider = "survivorData")
    @Step("Проверка получения младшего выжившего из списка")
    public void checkYoungestSurvivor(Survivor[] survivors, Survivor expectedYoungest) {
        for (Survivor survivor : survivors) {
            city.addSurvivor(survivor);
        }

        Survivor youngest = city.getYoungestSurvivor();

        Assertions.assertThat(youngest)
                .usingRecursiveComparison()
                .isEqualTo(expectedYoungest);
    }

}
