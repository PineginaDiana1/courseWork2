package ru.sportmaster.testng;

import courseWork2.City;
import courseWork2.Resource;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.EnumMap;
import java.util.Map;

public class GetResourceWithLowestStock {
    private City city;
    @BeforeMethod
    public void setUp() {
        city = new City("Test City");
    }


    @Test
    @Step("Проверка поиска ресурса с наименьшим запасом в таблице с одним ресурсом")
    public void testGetResourceWithLowestStock_SingleResource() {
        city.collectResources(Resource.Food);

        Resource resource = city.getResourceWithLowestStock();

        Assertions.assertThat(resource)
                .isEqualTo(Resource.Food);
    }

    @Test
    @Step("Проверка поиска ресурса с наименьшим запасом в таблице с несколькими ресурсами")
    public void testGetResourceWithLowestStock_MultipleResources() {

        city.collectResources(Resource.Food);
        city.collectResources(Resource.Weapons);
        city.collectResources(Resource.Drugs);

        Resource resource = city.getResourceWithLowestStock();

        Assertions.assertThat(resource)
                .isEqualTo(Resource.Food);
    }

    @Test
    @Step("Проверка поиска ресурса с наименьшим запасом при равных запасах")
    public void testGetResourceWithLowestStock_AllResourcesEqual() {

        Map<Resource, Integer> resources = new EnumMap<>(Resource.class);
        resources.put(Resource.Food, 10);
        resources.put(Resource.BuildingMaterials, 10);
        resources.put(Resource.Weapons, 10);
        resources.put(Resource.Drugs, 10);

        resources.forEach((res, amount) -> {
            for (int i = 0; i < amount; i++) {
                city.collectResources(res);
            }
        });

        Resource resource = city.getResourceWithLowestStock();

        Assertions.assertThat(resource)
                .isNotNull();
    }

    @Test
    @Step("Проверка поиска ресурса с наименьшим запасом в таблице с разными запасами")
    public void testGetResourceWithLowestStock_CustomResources() {
        Map<Resource, Integer> resources = new EnumMap<>(Resource.class);
        resources.put(Resource.Food, 5);
        resources.put(Resource.BuildingMaterials, 10);
        resources.put(Resource.Weapons, 3);
        resources.put(Resource.Drugs, 7);

        resources.forEach((res, amount) -> {
            for (int i = 0; i < amount; i++) {
                city.collectResources(res);
            }
        });

        Resource resource = city.getResourceWithLowestStock();

        Assertions.assertThat(resource)
                .isEqualTo(Resource.Food);
    }
}
