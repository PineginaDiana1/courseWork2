package courseWork2;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        City city = DataGenerator.generateRandomCity("New Hope", 10);
        DataGenerator.generateRandomResources(city);


        // Вывод информации о городе
        System.out.println("=== Информация о городе ===");
        System.out.println("Текущие запасы ресурсов: " + city.getResourcesReport());

        // Добавление нового выжившего
        Survivor newSurvivor = DataGenerator.generateRandomSurvivor();
        city.addSurvivor(newSurvivor);
        System.out.println("\nДобавлен новый выживший: " + newSurvivor);

        // Сбор ресурсов всеми выжившими
        city.collectResources(Resource.Food);
        city.collectResources(Resource.BuildingMaterials);
        city.collectResources(Resource.Drugs);
        city.collectResources(Resource.Weapons);
        System.out.println("\nПосле сбора еды всеми выжившими: " + city.getResourcesReport());

        // Сбор ресурсов определенными выжившими (например, только рабочими)
        List<Scavenger> workers = new ArrayList<>(city.getAllWorkers());
        city.collectResources(workers, Resource.BuildingMaterials);
        System.out.println("После сбора стройматериалов рабочими: " + city.getResourcesReport());

        // Поиск самого молодого и самого старого выжившего
        Survivor youngest = city.getYoungestSurvivor();
        Survivor oldest = city.getOldestSurvivor();
        System.out.println("\nСамый молодой выживший: " + youngest);
        System.out.println("Самый старый выживший: " + oldest);

        // Фильтрация выживших по ролям
        System.out.println("\n=== Фильтрация выживших по ролям ===");
        System.out.println("Медики: " + city.getAllMedics());
        System.out.println("Солдаты: " + city.getAllSoldiers());
        System.out.println("Рабочие: " + city.getAllWorkers());

        // Определение ресурса с наименьшими запасами
        Resource resourceWithLowestStock = city.getResourceWithLowestStock();
        System.out.println("\nРесурс с наименьшими запасами: " + resourceWithLowestStock);

        // Рассчет количества дней, на сколько хватит еды
        int foodDays = city.calculateFoodDays();
        System.out.println("Дни выживания с текущим запасом ресурсов: " + foodDays);



        // Вывод всех выживших в городе
        System.out.println("\n=== Все выжившие в городе ===");
        System.out.println(city.getSurvivors());

        }
    }

