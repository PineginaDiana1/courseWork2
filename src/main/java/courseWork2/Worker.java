package courseWork2;

public class Worker extends Survivor implements Scavenger{


    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public int gatherResources(Resource resource) {
        if (resource == Resource.BuildingMaterials) {
            return 8; // Рабочий лучше собирает стройматериалы
        }
        return 4; // Остальные ресурсы собирает хуже
    }
        }
