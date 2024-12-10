import java.util.HashMap;

public class VendingMachine {
    private double totalMoney;
    private HashMap<String, Integer> inventory;

    public VendingMachine(double money) {
        totalMoney = money;
        inventory = new HashMap<>();
        inventory.put("Pepsi", 10);
        inventory.put("Coca-Cola", 10);
        inventory.put("Dr. Pepper", 10);
        inventory.put("Mountain Dew", 10);
        inventory.put("Sprite", 10);
        inventory.put("Fanta", 10);
    }

    public void addMoney(double money) {
        totalMoney += money;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void resetMoney() {
        totalMoney = 0;
    }

    private boolean isDrinkAvailable(String drink) {
        return inventory.containsKey(drink) && inventory.get(drink) > 0;
    }

    // returns change
    public double makePurchase(String drink, double money) {
        if (!isDrinkAvailable(drink)) {
            System.out.println("Sorry, " + drink + " is not available.");
            return 0;
        }

        if (money < 2) {
            System.out.println("not enough money to purchase a drink.");
            return money;
        }

        inventory.put(drink, inventory.get(drink) - 1);
        totalMoney += 2;
        double change = money - 2;

        System.out.println("Here is your " + drink + ". Your change is: $" + change);
        return change;
    }

    public void restock(String drink, int quantity) {
        inventory.put(drink, inventory.getOrDefault(drink, 0) + quantity);
    }

    public void display() {
        for (String drink : inventory.keySet()) {
            System.out.println(drink + ": " + inventory.get(drink) + " left.");
        }
    }

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine(100);

        System.out.println("Total Money in Machine: $" + vm.getTotalMoney());

        vm.addMoney(10);
        System.out.println("Total Money after Adding $10: $" + vm.getTotalMoney());

        vm.makePurchase("Pepsi", 5); 
        vm.makePurchase("Pepsi", 1); 
        vm.makePurchase("Coca-Cola", 3);  

        vm.restock("Pepsi", 10);

        vm.display();

        vm.resetMoney();
        System.out.println("Money after reset: $" + vm.getTotalMoney());
    }
}
