package Bank;

import java.util.*;

public class Bank {
    HashMap<String, User> users;

    public Bank() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.id, user);
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public void processTransaction(User user, Scanner scanner) {
        String userChoice;
        while (true) {
            System.out.println("Please Select a Transaction:");
            System.out.println("P --- Obtain a Summary Statement");
            System.out.println("S --- Process a Savings Transaction");
            System.out.println("C --- Process a Checking Transaction");
            System.out.println("Q --- Quit");
            userChoice = scanner.nextLine().toUpperCase();

            if (userChoice.equals("P")) {
                for (Account account : user.accounts) {
                    account.displaySummary();
                }
            } else if (userChoice.equals("S")) {
                processTransaction(user, "savings", scanner);
            } else if (userChoice.equals("C")) {
                processTransaction(user, "checking", scanner);
            } else if (userChoice.equals("Q")) {
                break;
            }
        }
    }

    public void processTransaction(User user, String accountType, Scanner scanner) {
        Account selected = null;
        for (Account account : user.accounts) {
            if (account.type.equals(accountType)) {
                selected = account;
                break;
            }
        }

        if (selected != null) {
            System.out.println("D --- Process a Deposit");
            System.out.println("W --- Process a Withdrawal");
            System.out.println("C --- Cancel");
            String action = scanner.nextLine().toUpperCase();

            if (action.equals("D")) {
                System.out.println("Enter Deposit Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                selected.processTransaction("D", amount);
            } else if (action.equals("W")) {
                System.out.println("Enter Withdrawal Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                selected.processTransaction("W", amount);
            }
        }
    }
}
