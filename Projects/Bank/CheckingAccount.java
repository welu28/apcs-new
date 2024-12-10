package Bank;

public class CheckingAccount extends Account {
    double overdraftLimit;

    public CheckingAccount(String accountId, double balance, double overdraftLimit) {
        super(accountId, balance, "checking");
        this.overdraftLimit = overdraftLimit;
    }

    public void processTransaction(String type, double amount) {
        if (type.equals("D")) {
            balance += amount;
            System.out.println("deposited, new balance: " + balance);
        } else if (type.equals("W")) {
            if (balance - amount >= -overdraftLimit) {
                balance -= amount;
                System.out.println("withdrew, new balance: " + balance);
            } else {
                System.out.println("overdraft limited exceeded, cannot withdraw");
            }
        }
    }

    public void displaySummary() {
        System.out.println("balance: " + balance + ", overdraft limit: " + overdraftLimit);
    }
}
