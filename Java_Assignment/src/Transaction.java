class Transaction {
    private double amount;
    private String details;

    public Transaction(double amount, String details) {
        // The Transaction class is only used by the BankAccount class, so it makes sense to make it private.
        this.details = details;
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public double getAmount() {
        return amount;
    }
}
