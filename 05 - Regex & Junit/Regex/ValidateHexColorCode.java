import java.util.regex.*;
public class ValidateHexColorCode {
    public static void main(String[] args) {
        String hexColor = "#FFA500";
        String regex = "^#[0-9a-fA-F]{6}$";
        if (hexColor.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
