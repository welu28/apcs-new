package Bank;

public class SavingsAccount extends Account {

    public SavingsAccount(String id, double balance) {
        super(id, balance, "savings");
    }

    public void processTransaction(String type, double amount) {
        if (type.equals("D")) {
            balance += amount;
            System.out.println("deposited, new balance: " + balance);
        } else if (type.equals("W")) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("withdrawed, new balance: " + balance);
            } else {
                System.out.println("not enough money.");
            }
        }
    }

    public void displaySummary() {
        System.out.println("balance = " + balance);
    }
}
