import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private String name;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(String description, double amount) {
        Transaction transaction = new Transaction(amount, description);
        transactions.add(transaction);
        // Update the balance
        // TODO : how to know a double value is negative or positive?
        // add on a negative value is the same as subtracting a positive value
        balance += amount;
    }
}
