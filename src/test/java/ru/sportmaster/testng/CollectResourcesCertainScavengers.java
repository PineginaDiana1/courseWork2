package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectResourcesCertainScavengers {

    private City city;
    private Survivor scavenger1;
    private Survivor scavenger2;
    @BeforeMethod
    void setUp() {
        city = new City("Test City");
        scavenger1 = new Worker("John Doe", 30);
        scavenger2 = new Worker("Jane Smith", 25);
        city.addSurvivor(scavenger1);
        city.addSurvivor(scavenger2);

    }


@Test
@Step("Проверка сбора ресурсов рабочими")
public void testCollectResources_WithWorkers() {
    List<Scavenger> workers = new ArrayList<>(city.getAllWorkers());
    city.collectResources(workers, Resource.BuildingMaterials);

    Assertions.assertThat(city.getResourcesReport())
            .contains("BuildingMaterials: " + (((Worker) scavenger1).gatherResources(Resource.BuildingMaterials) + ((Worker) scavenger2).gatherResources(Resource.BuildingMaterials)));
}

}
