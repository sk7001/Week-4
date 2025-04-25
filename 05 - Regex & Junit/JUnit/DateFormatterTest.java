import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
class DateFormatterTest {
   DateFormatter df = new DateFormatter();
   @Test
   void testValidDateFormat() throws ParseException {
       assertEquals("09-05-2025", df.formatDate("2025-05-09"));
   }
   @Test
   void testInvalidDateFormat() {
       assertThrows(ParseException.class, () -> df.formatDate("09/05/2025"));
   }
}
