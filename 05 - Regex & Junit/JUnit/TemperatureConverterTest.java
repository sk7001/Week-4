import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class TemperatureConverterTest {
   TemperatureConverter tc = new TemperatureConverter();
   @Test
   void testCelsiusToFahrenheit() {
       assertEquals(98.6, tc.celsiusToFahrenheit(37), 0.1);
   }
   @Test
   void testFahrenheitToCelsius() {
       assertEquals(0, tc.fahrenheitToCelsius(32), 0.1);
   }
}
