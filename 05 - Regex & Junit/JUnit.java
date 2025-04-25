/* Problem 1
public class JUnit {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divide by zero");
        return a / b;
    }
}
*/

/* Problem 2
class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
*/

/* Problem 3
import java.util.List;

class ListManager {
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }
}
*/

/* Problem 4
class Divider {
    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}
*/

/* Problem 5
class DatabaseConnection {
    public boolean connected = false;

    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }
}
*/

/* Problem 6
class NumberUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
*/

/* Problem 7
class Performance {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "done";
    }
}
*/

/* Problem 8
import java.io.*;

class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(content);
        writer.close();
    }

    public String readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        return sb.toString();
    }
}
*/

// Advanced JUnit Practice Problems

/* Problem 1
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
*/

/* Problem 2
class PasswordValidator {
    public boolean isValid(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*");
    }
}
*/

/* Problem 3
class TemperatureConverter {
    public double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
}
*/

/* Problem 4
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateFormatter {
    public String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }
}
*/

/* Problem 5
class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username.isEmpty() || email.isEmpty() || password.length() < 8) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
*/
