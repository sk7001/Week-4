import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class PasswordValidatorTest {
   PasswordValidator validator = new PasswordValidator();
   @Test
   void testValidPassword() {
       assertTrue(validator.isValid("StrongPass1"));
   }
   @Test
   void testInvalidPassword() {
       assertFalse(validator.isValid("weak"));
   }
}
