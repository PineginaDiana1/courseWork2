package ru.sportmaster.testng;

import courseWork2.*;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class GenerateRandomSurvivor {

        @Test
        @Step("Проверка корректности имени выжившего")
        public void testGenerateRandomSurvivor_NameIsValid() {

            Survivor survivor = DataGenerator.generateRandomSurvivor();

            Assertions.assertThat(survivor.getName())
                    .isNotBlank()
                    .matches("[A-Za-z .]+");
        }

        @Test
        @Step("Проверка корректности возраста выжившего")
        public void testGenerateRandomSurvivor_AgeIsValid() {

            Survivor survivor = DataGenerator.generateRandomSurvivor();

            Assertions.assertThat(survivor.getAge())
                    .isBetween(0, 120);
        }

        @Test
        @Step("Проверка корректности роли выжившего")
        public void testGenerateRandomSurvivor_RoleIsValid() {

            Survivor survivor = DataGenerator.generateRandomSurvivor();

            Assertions.assertThat(survivor)
                    .isInstanceOfAny(Medic.class, Worker.class, Soldier.class);
        }
    }

