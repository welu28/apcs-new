package Bank;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Account openAccount(String customerName, double initialDeposit) {
        Account newAccount = new Account(generateAccountNumber(), initialDeposit);
        Customer newCustomer = new Customer(customerName, newAccount);
        accounts.add(newAccount);
        System.out.println("Account created for " + customerName + " with account number: " + newAccount.getAccountNumber());
        return newAccount;
    }

    private int generateAccountNumber() {
        return (int)(Math.random() * 1000000); 
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
