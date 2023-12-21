import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingSystem {

    // accounts is static, because we want to access it from the main method, which
    // is static
    public static List<BankAccount> accounts = new ArrayList<>();
    // List and not an ArrayList, because we only need to access it by index, and
    // not by any other method

    public static void listAllAccountNames() {
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-20s%n", "Account Names:");
        for (BankAccount account : accounts) {
            System.out.println(account.getName());
        }
        System.out.println("----------------------------------------------------------------------");
    }

    public static void viewAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the account you want to view: ");
        String accountName = scanner.nextLine();

        for (BankAccount account : accounts) {
            if (account.getName().equalsIgnoreCase(accountName)) {
                System.out.println("----------------------------------------------------------------------");
                System.out.printf("%-20s%-20s%n", "Account Name:", "Account Balance:");
                System.out.printf("%-20s%-20.2f%n%n", account.getName(), account.getBalance());

                System.out.printf("%-20s%n",  "|Transactions|");
                for (Transaction transaction : account.getTransactions()) {
                    System.out.printf("%-20s%-20.2f%n", "[Details: " + transaction.getDetails() + "]", transaction.getAmount());
                }

                System.out.println("----------------------------------------------------------------------");
                return;
            }
        }
        System.out.println("Account not exist.");
    }

    public static void removeAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the account you want to remove: ");
        String accountName = scanner.nextLine();

        for (BankAccount account : accounts) {
            if (account.getName().equalsIgnoreCase(accountName)) {
                accounts.remove(account);
                System.out.println("Account removed.");
                return;
            }
        }
        System.out.println("Account not exist.");
    }

    public static void addTransaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the account you want to add transaction: ");
        String accountName = scanner.nextLine();

        for (BankAccount account : accounts) {
            if (account.getName().equalsIgnoreCase(accountName)) {
                System.out.print("Enter transaction details: ");
                String description = scanner.nextLine();
                System.out.print("Enter transaction amount: ");
                double amount = scanner.nextDouble();
                System.out.println("Transaction type: " + (amount < 0 ? "Withdrawal" : "Deposit"));
                account.addTransaction(description, amount);
                System.out.println("Transaction added.");
                return;
            }
        }
        System.out.println("Account not exist.");
    }

    public static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the new account: ");
        String accountName = scanner.nextLine();
        System.out.print("Enter the initial balance: ");
        double initBalance = scanner.nextDouble();
        accounts.add(new BankAccount(accountName, initBalance));
        System.out.println("Account created.");
    }

    // TODO -- read from csv file
    public static void readFromCSVFile() {
        try {
            File file = new File("src/csv/accounts.csv");
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    String name = parts[0];
                    double balance = Double.parseDouble(parts[1]);
                    // check if the account already exists
                    // if not, add it to the list
                    if(accounts.size() == 0) {
                        accounts.add(new BankAccount(name, balance));
                    } else { 
                        boolean isExist = false;    // assume the account does not exist
                        for (BankAccount account : accounts) {
                            if(account.getName().equalsIgnoreCase(name)) {
                                isExist = true;
                                break;
                            }
                        }
                        if(!isExist) { // if the account does not exist, add it to the list
                            accounts.add(new BankAccount(name, balance));
                        }
                    }
                }
                System.out.println("Accounts loaded successfully from CSV file.");
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // TODO -- write to csv file
    public static void writeToCSVFile() {
        try {
            File file = new File("src/csv/accounts.csv");
            FileWriter writer = new FileWriter(file);
            for (BankAccount account : accounts) {
                writer.write(account.getName() + "," + account.getBalance() + "\n");
            }
            System.out.println("Accounts write successfully to CSV file.");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void editingWithCSVFile() {
        System.out.println("Enter the operation you want to make with CSV file.(1 for read, 2 for write)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                readFromCSVFile();
                break;
            case 2:
                writeToCSVFile();
                break;
            default:
                System.out.println("Invalid choice. Please try again(error input: " + choice + ").");
        }
    }
}
