package courseWork2;

public class Medic extends Survivor implements Scavenger {

    public Medic(String name, int age) {
        super(name, age);
    }

    @Override
    public int gatherResources(Resource resource) {
        if (resource == Resource.Drugs) {
            return 10; // Медик лучше собирает медикаменты
        }
        return 6; // Остальные ресурсы собирает хуже
    }
    }
