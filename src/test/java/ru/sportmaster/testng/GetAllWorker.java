package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllWorker {
    private City city;
    @BeforeMethod
    void setUp() {
        city = new City("Test City");
    }

    @Test
    @Step("Проверка получения пустого списка рабочих")
    public void checkGetAllWorkerNoWorker() {

        Survivor survivor = new Medic("Alex Russo", 3);
        Survivor survivor1 = new Soldier("John Doe", 3);
        city.addSurvivor(survivor);
        city.addSurvivor(survivor1);

        List<Worker> worker = city.getAllWorkers();

        Assertions.assertThat(worker)
                .isEmpty();
    }

    @Test
    @Step("Проверка получения списка рабочих")
    public void checkGetAllWorker() {

        Worker worker = new Worker("Alex Russo", 3);
        Medic medic = new Medic("John Doe", 5);
        Soldier soldier = new Soldier("John Snow", 30);
        city.addSurvivor(worker);
        city.addSurvivor(medic);
        city.addSurvivor(soldier);

        List<Worker> workers = city.getAllWorkers();

        Assertions.assertThat(workers)
                .hasSize(1)
                .containsExactly(worker);
    }

}
