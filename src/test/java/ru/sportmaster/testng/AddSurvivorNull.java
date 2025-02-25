package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddSurvivorNull {

    private City city;
    @BeforeMethod
    void setUp() {
        city = new City("Test City");
    }


    @Test
    @Step("Проверка null")
    void testAddNullSurvivor() {

        Assertions.assertThatThrownBy(() -> city.addSurvivor(null))
                .hasMessage("Survivor cannot be null");
    }
}
