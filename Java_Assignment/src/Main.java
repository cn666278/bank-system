import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the bank system by adding four initial accounts
        BankingSystem.accounts.add(new BankAccount("Steven Chen", 1000.0));
        BankingSystem.accounts.add(new BankAccount("Jenny Lilly", 500.0));
        BankingSystem.accounts.add(new BankAccount("Kim Petty", 90.0));
        BankingSystem.accounts.add(new BankAccount("John Snow", 7500.0));

        while (true) {
            System.out.println("**********************************************************************");
            System.out.println("**************** Welcome to Steven Banking System ********************");
            System.out.println("**********************************************************************");
            System.out.println("Banking System Menu:");
            System.out.println("[1] List all bank accounts’ names");
            System.out.println("[2] View an individual bank account(with all transactions records)");
            System.out.println("[3] Remove a bank account");
            System.out.println("[4] Add a new transaction to a bank account(-: Withdrawal / +: Deposit)"); // TODO transfer to another account
            System.out.println("[5] Create a new bank account");
            System.out.println("[6] Editing with CSV file");
            System.out.println("[7] Exit the program");
            System.out.println("**********************************************************************");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    BankingSystem.listAllAccountNames();
                    break;
                case 2:
                    BankingSystem.viewAccount();
                    break;
                case 3:
                    BankingSystem.removeAccount();
                    break;
                case 4:
                    BankingSystem.addTransaction();
                    break;
                case 5:
                    BankingSystem.createAccount();
                    break;
                case 6:
                    BankingSystem.editingWithCSVFile();
                    break;
                case 7:
                    System.out.println("Exiting successfully. Thank you for using the Banking Application, see you soon.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again(error input: " + choice + ").");
            }
        }
    }
}

