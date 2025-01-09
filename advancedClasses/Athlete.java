package advancedClasses;

public class Athlete {
    private String name;
    private String sport;
    private double hoursTraining;

    public Athlete(String name, String sport) {
        this.name = name;
        this.sport = sport;
        this.hoursTraining = 0;
    }

    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }

    public void train(double hours) {
        this.hoursTraining += hours;
    }

    public double getHoursTraining() {
        return hoursTraining;
    }
}

