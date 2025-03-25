class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class BankAccount {
    private double balance;
    public BankAccount(double balance) {
        this.balance = balance;
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) throw new IllegalArgumentException("Invalid amount!");
        if (amount > balance) throw new InsufficientBalanceException("Insufficient balance!");
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}
public class BankAccountTransactionException {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        try {
            account.withdraw(6000);
        } catch (IllegalArgumentException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
