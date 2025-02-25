package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class AddSurvivor {

    private City city;
    @BeforeMethod
    void setUp() {
        city = new City("Test City");
    }


@Test
@Step("Проверка добавления выжившего")
    public void testAddSurvivor() {

    Survivor survivor = new Medic("John Doe", 30);

    city.addSurvivor(survivor);

    List<Survivor> survivors = city.getSurvivors();
    Assertions.assertThat(survivors)
            .hasSize(1)
            .containsExactly(survivor);
}

    @Test
    @Step("Проверка добавления нескольких выживших")
    void testAddMultipleSurvivors() {

        Survivor survivor1 = new Medic("John Doe", 30);
        Survivor survivor2 = new Soldier("Jane Smith", 25);
        Survivor survivor3 = new Worker("Alice Brown", 40);

        city.addSurvivor(survivor1);
        city.addSurvivor(survivor2);
        city.addSurvivor(survivor3);

        List<Survivor> survivors = city.getSurvivors();
        Assertions.assertThat(survivors)
                .hasSize(3)
                .containsExactlyInAnyOrder(survivor1, survivor2, survivor3);
    }

}
