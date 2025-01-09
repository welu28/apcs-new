package advancedClasses;

public class SkiJumper extends Athlete implements Flier, Comparable<SkiJumper> {
    private int numberOfJumps;

    public SkiJumper(String name, String sport) {
        super(name, sport);
        this.numberOfJumps = 0;
    }

    public int getJumps() {
        return numberOfJumps;
    }

    @Override
    public void train(double hours) {
        // SkiJumper-specific work (e.g., jump practice)
        this.numberOfJumps += (int) hours; 
        super.train(hours); // Call the parent class train method
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying during a ski jump!");
    }

    @Override
    public int compareTo(SkiJumper other) {
        if (this.numberOfJumps < other.numberOfJumps)
            return -1;
        if (this.numberOfJumps > other.numberOfJumps)
            return 1;
        return 0;
    }
}
