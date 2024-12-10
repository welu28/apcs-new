package Bank;

import java.util.*;

public class User {
    String id;
    String pin;
    ArrayList<Account> accounts;

    public User(String id, String pin) {
        this.id = id;
        this.pin = pin;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public boolean verifyPin(String inputPin) {
        return pin.equals(inputPin);
    }

    public void displayAccounts() {
        System.out.print("your accounts: ");
        for (Account account : accounts) {
            System.out.print(account.type + " ");
        }
        System.out.println();
    }
}
