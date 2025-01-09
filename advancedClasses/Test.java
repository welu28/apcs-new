package advancedClasses;

public class Test {
    public static void main(String[] args) {
        SkiJumper j1 = new SkiJumper("Eric", "Ski Jumping");
        SkiJumper j2 = new SkiJumper("Steve", "Ski Jumping");
        Athlete j3 = new SkiJumper("Mike", "Ski Jumping");

        j1.train(10);
        j2.train(5);

        if (j1.compareTo(j2) > 0)
            System.out.println(j1.getName() + " has more jumps than " + j2.getName());
        else if (j2.compareTo(j1) > 0)
            System.out.println(j2.getName() + " has more jumps than " + j1.getName());

    }
}
