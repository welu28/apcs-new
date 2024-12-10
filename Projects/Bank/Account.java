package Bank;

public abstract class Account {
    String id;
    double balance;
    String type;

    Account(String id, double balance, String type) {
        this.id = id;
        this.balance = balance;
        this.type = type;
    }

    public abstract void processTransaction(String transactionType, double amount);
    public abstract void displaySummary();
}
