package courseWork2;

public abstract class Survivor {
    String name;
    int age;

    public Survivor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Survivor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
