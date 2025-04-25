import java.util.regex.*;
public class ValidateIPAddress {
    public static void main(String[] args) {
        String ip = "192.168.1.1";
        String regex = "^((25[0-5]|2[0-4]\\d|1?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|1?\\d\\d?)$";
        if (ip.matches(regex)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
