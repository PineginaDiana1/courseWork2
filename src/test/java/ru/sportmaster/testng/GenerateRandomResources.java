package ru.sportmaster.testng;

import courseWork2.City;
import courseWork2.DataGenerator;
import courseWork2.Resource;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;

public class GenerateRandomResources {
    private City city;

        @BeforeMethod
        public void setUp() {

            city = new City("Test City");
        }

        @Test
        @Step("Проверка генерации ресурсов для всех типов")
        public void testGenerateRandomResources_ResourcesAreGenerated() {

            Map<Resource, Integer> resources = DataGenerator.generateRandomResources(city);

            assertThat(resources)
                    .hasSize(Resource.values().length);

            resources.forEach((resource, amount) -> {
                assertThat(amount)
                        .as("Проверка количества ресурсов для " + resource)
                        .isBetween(0, 100);
            });
        }


        @Test
        @Step("Проверка, что ресурсы разные при многократной генерации")
        public void testGenerateRandomResources_MultipleCalls() {
            Map<Resource, Integer> resources1 = DataGenerator.generateRandomResources(city);
            Map<Resource, Integer> resources2 = DataGenerator.generateRandomResources(city);

            assertThat(resources1)
                    .isNotEqualTo(resources2);
        }

}
