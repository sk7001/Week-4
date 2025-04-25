import java.util.regex.*;
public class ValidateCreditCardNumber {
    public static void main(String[] args) {
        String visa = "4111111111111111";
        String mastercard = "5111111111111111";
        String regex = "^(4\\d{15}|5\\d{15})$";
        System.out.println(visa.matches(regex) ? "Valid" : "Invalid");
        System.out.println(mastercard.matches(regex) ? "Valid" : "Invalid");
    }
}
