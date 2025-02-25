package courseWork2;

public class Soldier extends Survivor implements Scavenger {
    public Soldier(String name, int age) {
        super(name, age);
    }

    @Override
    public int gatherResources(Resource resource) {
        if (resource == Resource.Weapons) {
            return 7; // Солдат лучше собирает оружие
        }
        return 5; // Остальные ресурсы собирает хуже
    }
}
