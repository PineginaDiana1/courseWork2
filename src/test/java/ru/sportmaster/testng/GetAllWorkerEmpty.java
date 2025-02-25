package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllWorkerEmpty {
    private City city;

    @BeforeMethod
    void setUp() {
        city = new City("Test City");
    }

    @Test
    @Step("Проверка получения пустого результата")
    public void checkGetAllWorkerFromEmptyList() {
        List<Worker> survivor = city.getAllWorkers();

        Assertions.assertThat(survivor)
                .isEmpty();
    }
}
