package Bank;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        User user1 = new User("12345", "8613");
        user1.addAccount(new SavingsAccount("12345", 500.00));
        user1.addAccount(new CheckingAccount("12345", 1000.00, 200.00));

        User user2 = new User("67890", "1234");
        user2.addAccount(new SavingsAccount("67890", 300.00));

        User user3 = new User("54321", "5678");
        user3.addAccount(new CheckingAccount("54321", 200.00, 50.00));

        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);

        System.out.println("Please enter your ID and Password: ");
        String userId = scanner.nextLine();
        String pin = scanner.nextLine();

        User user = bank.getUser(userId);
        if (user != null && user.verifyPin(pin)) {
            System.out.println("Welcome, Valued Customer " + userId);
            user.displayAccounts();
            bank.processTransaction(user, scanner);
        } else {
            System.out.println("Invalid ID or PIN.");
        }

        scanner.close();
    }
}
