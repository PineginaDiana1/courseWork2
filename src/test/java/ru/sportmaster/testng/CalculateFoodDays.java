package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculateFoodDays {

    private City city;

    @BeforeMethod
    public void setUp() {
        city = new City("Test City");
    }

    @Test
    @Step("Проверка расчета дней, когда еды нет")
    public void testCalculateFoodDays_NoFood() {
        city.addSurvivor(new Medic("John Doe", 30));
        city.addSurvivor(new Soldier("Jane Smith", 25));

        int days = city.calculateFoodDays();

        Assertions.assertThat(days)
                .isEqualTo(0);
    }

    @Test
    @Step("Проверка расчета дней, когда еды достаточно")
    public void testCalculateFoodDays_EnoughFood() {
        city.addSurvivor(new Medic("John Doe", 30));
        city.addSurvivor(new Soldier("Jane Smith", 25));

            city.collectResources(Resource.Food);


        int days = city.calculateFoodDays();

        Assertions.assertThat(days)
                .isEqualTo(5);
    }
}
