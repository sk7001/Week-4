
/* Problem 1
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    JUnit calc = new JUnit();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calc.subtract(4, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calc.divide(4, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }
}
*/

/* Problem 2
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
    StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("cba", utils.reverse("abc"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
    }
}
*/

/* Problem 3
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {
    ListManager manager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        assertTrue(list.contains(5));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        manager.removeElement(list, 10);
        assertFalse(list.contains(10));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(2, manager.getSize(list));
    }
}
*/

/* Problem 4
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DividerTest {
    Divider d = new Divider();

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> d.divide(10, 0));
    }
}
*/

/* Problem 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DatabaseConnectionTest {
    DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(db.isConnected());
    }

    @Test
    void testConnectionClosed() {
        db.disconnect();
        assertFalse(db.isConnected());
    }
}
*/

/* Problem 6
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtilsTest {
    NumberUtils utils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testEvenNumbers(int number) {
        assertTrue(utils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    void testOddNumbers(int number) {
        assertFalse(utils.isEven(number));
    }
}
*/

/* Problem 7
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class PerformanceTest {
    Performance perf = new Performance();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() throws InterruptedException {
        perf.longRunningTask();
    }
}
*/

/* Problem 8
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

class FileProcessorTest {
    FileProcessor fp = new FileProcessor();
    String filename = "testfile.txt";

    @Test
    void testWriteAndRead() throws IOException {
        fp.writeToFile(filename, "Hello");
        String content = fp.readFromFile(filename);
        assertEquals("Hello", content);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        fp.writeToFile(filename, "Data");
        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    void testReadNonExistingFileThrowsException() {
        assertThrows(IOException.class, () -> {
            fp.readFromFile("nonexistent.txt");
        });
    }
}
*/

// Advanced JUnit Practice Problems

/* Problem 1
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
*/

/* Problem 2
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
*/

/* Problem 3
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
*/

/* Problem 4
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
*/

/* Problem 5
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
*/