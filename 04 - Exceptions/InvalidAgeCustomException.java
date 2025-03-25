import java.util.*;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class InvalidAgeCustomException {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("Age must be 18 or above");
        System.out.println("Access granted!");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        try {
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
