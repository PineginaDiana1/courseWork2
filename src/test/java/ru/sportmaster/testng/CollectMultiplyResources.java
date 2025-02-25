package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CollectMultiplyResources {

    private City city;
    private Survivor scavenger1;
    private Survivor scavenger2;
    @BeforeMethod
    void setUp() {
        city = new City("Test City");
        scavenger1 = new Worker("John Doe", 30);
        scavenger2 = new Soldier("Jane Smith", 25);
        city.addSurvivor(scavenger1);
        city.addSurvivor(scavenger2);
    }


    @Test
    @Step("Проверка сбора нескольких ресурсов выжившими")
    public void testCollectMultiplyResources_WithScavengers() {

        city.collectResources(Resource.Food);
        city.collectResources(Resource.Drugs);

        Assertions.assertThat(city.getResourcesReport())
                .contains("Food: " + (((Worker) scavenger1).gatherResources(Resource.Food) + ((Soldier) scavenger2).gatherResources(Resource.Food)))
                .contains("Drugs: " + (((Worker) scavenger1).gatherResources(Resource.Drugs) + ((Soldier) scavenger2).gatherResources(Resource.Drugs)));
    }

}
