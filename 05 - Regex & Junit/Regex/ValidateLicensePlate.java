import java.util.regex.*;
public class ValidateLicensePlate {
    public static void main(String[] args) {
        String licensePlate = "AB1234";
        String regex = "^[A-Z]{2}\\d{4}$";
        if (licensePlate.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
