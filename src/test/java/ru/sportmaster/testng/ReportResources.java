package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.EnumMap;
import java.util.Map;

public class ReportResources {

    private City city;

    @BeforeMethod
    void setUp() {
        city = new City("Test City");
    }

    @Test
    @Step("Проверка отчета для пустой таблицы ресурсов")
    public void testGetResourcesReport_EmptyResources() {

        String report = city.getResourcesReport();

        Assertions.assertThat(report)
                .isEqualTo("Food: 0, BuildingMaterials: 0, Weapons: 0, Drugs: 0");
    }


    @Test
    @Step("Проверка отчета для одного ресурса")
    public void testGetResourcesReport_SingleResource() {

        city.collectResources(Resource.Food);

        String report = city.getResourcesReport();

        Assertions.assertThat(report)
                .contains("Food: " + city.getResources().get(Resource.Food))
                .contains("BuildingMaterials: 0")
                .contains("Weapons: 0")
                .contains("Drugs: 0");
    }

    @Test
    @Step("Проверка отчета для нескольких ресурсов")
    public void testGetResourcesReport_MultipleResources() {

        city.collectResources(Resource.Food);
        city.collectResources(Resource.Weapons);
        city.collectResources(Resource.BuildingMaterials);

        String report = city.getResourcesReport();

        Assertions.assertThat(report)
                .contains("Food: " + city.getResources().get(Resource.Food))
                .contains("Weapons: " + city.getResources().get(Resource.Weapons))
                .contains("Drugs: " + city.getResources().get(Resource.Drugs))
                .contains("BuildingMaterials: 0");
    }
}


