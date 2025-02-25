package courseWork2;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataGenerator {

    private static final Faker faker = Faker.instance();


    public static Survivor generateRandomSurvivor() {
        String name = faker.name().fullName();
        int age = faker.number().numberBetween(0, 120);
        int role = faker.number().numberBetween(0, 3);

        return switch (role) {
            case 0 -> new Medic(name, age);
            case 1 -> new Worker(name, age);
            case 2 -> new Soldier(name, age);
            default -> throw new IllegalStateException("Unexpected role: " + role);
        };
    }

    private static List<Survivor> generateRandomSurvivors(int count) {
        return Stream.generate(DataGenerator::generateRandomSurvivor)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static City generateRandomCity(String name, int survivorCount) {
        City city = new City(name);
        List<Survivor> survivors = generateRandomSurvivors(survivorCount);
        survivors.forEach(city::addSurvivor);
        return city;
    }

    public static Map<Resource, Integer> generateRandomResources(City city) {
        Map<Resource, Integer> resources = new EnumMap<>(Resource.class);
        Arrays.stream(Resource.values()).forEach(res -> resources.put(res, faker.number().numberBetween(0, 100)));

        for (Map.Entry<Resource, Integer> entry : resources.entrySet()) {

            city.collectResources(entry.getKey());
        }
        return resources;
    }
}


