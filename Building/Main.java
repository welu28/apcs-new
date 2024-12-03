package Building;

abstract class Building implements Comparable<Building> {
    private int floors = 5;

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public abstract double getTotalCost();

    public abstract void calcCost(double taxAmount);

    @Override
    public int compareTo(Building other) {
        if (this.getTotalCost() < other.getTotalCost()) {
            return -1; 
        }
        else if (this.getTotalCost() > other.getTotalCost()) {
            return 1; 
        }
        else {
            return 0; 
        }
    }
}

class Apartment extends Building {
    private double costPerFloor;
    private double totalCost;

    public Apartment(double costPerFloor) {
        this.costPerFloor = costPerFloor;
    }

    public double getCostPerFloor() {
        return costPerFloor;
    }

    @Override
    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public void calcCost(double tax) {
        totalCost = (costPerFloor * getFloors()) + tax;
    }

    @Override
    public String toString() {
        return "Total Cost: " + totalCost;
    }
}

class OfficeSpace extends Building {
    private double costPerFloor;
    private double squareFeetPerFloor;
    private double totalCost;

    public OfficeSpace(double costPerFloor, double squareFeetPerFloor) {
        this.costPerFloor = costPerFloor;
        this.squareFeetPerFloor = squareFeetPerFloor;
    }

    public double getCostPerFloor() {
        return costPerFloor;
    }

    public double getSquareFeetPerFloor() {
        return squareFeetPerFloor;
    }

    @Override
    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public void calcCost(double taxAmount) {
        totalCost = (costPerFloor * getFloors()) + taxAmount + (squareFeetPerFloor * 2.75);
    }

    @Override
    public String toString() {
        return "Total Cost: " + totalCost;
    }
}

public class Main {
    public static void main(String[] args) {
        Building apartment = new Apartment(15.5);
        apartment.calcCost(12.5);
        System.out.println(apartment.toString());

        Building officeSpace = new OfficeSpace(20.0, 500.0);
        officeSpace.calcCost(50.0);
        System.out.println(officeSpace.toString());
    }
}
