package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllSoldier {
    private City city;
    @BeforeMethod
    void setUp() {
        city = new City("Test City");
    }

    @Test
    @Step("Проверка получения пустого списка солдатов")
    public void checkGetAllSoldierNoSoldier() {

        Survivor survivor = new Worker("Alex Russo", 3);
        Survivor survivor1 = new Medic("John Doe", 3);
        city.addSurvivor(survivor);
        city.addSurvivor(survivor1);

        List<Soldier> soldier = city.getAllSoldiers();

        Assertions.assertThat(soldier)
                .isEmpty();
    }

    @Test
    @Step("Проверка получения списка солдатов")
    public void checkGetAllSoldier() {

        Worker worker = new Worker("Alex Russo", 3);
        Medic medic = new Medic("John Doe", 5);
        Soldier soldier = new Soldier("John Snow", 30);
        city.addSurvivor(worker);
        city.addSurvivor(medic);
        city.addSurvivor(soldier);

        List<Soldier> soldiers = city.getAllSoldiers();

        Assertions.assertThat(soldiers)
                .hasSize(1)
                .containsExactly(soldier);
    }

}
