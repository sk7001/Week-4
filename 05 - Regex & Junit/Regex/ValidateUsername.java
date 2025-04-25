import java.util.regex.*;
public class ValidateUsername {
    public static void main(String[] args) {
        String username = "user_123";
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        if (username.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
