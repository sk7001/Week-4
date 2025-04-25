import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class BankAccountTest {
   BankAccount account = new BankAccount();
   @Test
   void testDeposit() {
       account.deposit(100);
       assertEquals(100, account.getBalance());
   }
   @Test
   void testWithdraw() {
       account.deposit(200);
       account.withdraw(100);
       assertEquals(100, account.getBalance());
   }
   @Test
   void testWithdrawInsufficientFunds() {
       assertThrows(IllegalArgumentException.class, () -> account.withdraw(100));
   }
}
