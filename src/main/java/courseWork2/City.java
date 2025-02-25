package courseWork2;

import java.util.*;
import java.util.stream.Collectors;

public class City {
    private String name;
    private List<Survivor> survivors;
    private Map<Resource, Integer> resources;

    public City(String name) {
        this.name = name;
        this.survivors = new ArrayList<>();
        this.resources = new EnumMap<>(Resource.class);
        Arrays.stream(Resource.values()).forEach(resource -> resources.put(resource, 0));
    }

    public Map<Resource, Integer> getResources() {
        return resources;
    }

    public void addSurvivor(Survivor survivor) {
    if (survivor == null) {
        throw new IllegalArgumentException("Survivor cannot be null");
    }
    survivors.add(survivor);
}

    public void collectResources(Resource resource) {
        int total = survivors.stream()
                .filter(s -> s instanceof Scavenger)
                .mapToInt(s -> ((Scavenger) s).gatherResources(resource))
                .sum();
        resources.put(resource, resources.get(resource) + total);
    }

    public void collectResources(List<Scavenger> scavengers, Resource resource) {
        int total = scavengers.stream()
                .mapToInt(s -> s.gatherResources(resource))
                .sum();
        resources.put(resource, resources.get(resource) + total);
    }

    public String getResourcesReport() {
        return resources.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "));
    }

    public List<Survivor> getSurvivors() {
        return survivors;
    }

    public Survivor getYoungestSurvivor() {
        return survivors.stream()
                .min(Comparator.comparingInt(Survivor::getAge))
                .orElse(null);
    }

    public Survivor getOldestSurvivor() {
        return survivors.stream()
                .max(Comparator.comparingInt(Survivor::getAge))
                .orElse(null);
    }


    public List<Medic> getAllMedics() {
        return survivors.stream()
                .filter(s -> s instanceof Medic)
                .map(s -> (Medic) s)
                .collect(Collectors.toList());
    }

    public List<Soldier> getAllSoldiers() {
        return survivors.stream()
                .filter(s -> s instanceof Soldier)
                .map(s -> (Soldier) s)
                .collect(Collectors.toList());
    }

    public List<Worker> getAllWorkers() {
        return survivors.stream()
                .filter(s -> s instanceof Worker)
                .map(s -> (Worker) s)
                .collect(Collectors.toList());
    }

    public Resource getResourceWithLowestStock() {
        return resources.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }


    public int calculateFoodDays() {
        int food = resources.get(Resource.Food);
        return food / survivors.size();
    }

}
