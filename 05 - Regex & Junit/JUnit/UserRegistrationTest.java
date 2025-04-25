import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class UserRegistrationTest {
   UserRegistration ur = new UserRegistration();
   @Test
   void testValidRegistration() {
       ur.registerUser("user", "email@example.com", "password123");
   }
   @Test
   void testInvalidRegistration() {
       assertThrows(IllegalArgumentException.class, () ->
           ur.registerUser("", "", "123"));
   }
}
