class BankAccount {
   private double balance = 0;
   public void deposit(double amount) {
       if (amount > 0) balance += amount;
   }
   public void withdraw(double amount) {
       if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
       balance -= amount;
   }
   public double getBalance() {
       return balance;
   }
}
