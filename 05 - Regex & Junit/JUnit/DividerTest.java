import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class DividerTest {
   Divider d = new Divider();
   @Test
   void testDivideByZero() {
       assertThrows(ArithmeticException.class, () -> d.divide(10, 0));
   }
}
