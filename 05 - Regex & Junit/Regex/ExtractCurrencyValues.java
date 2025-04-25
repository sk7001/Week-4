import java.util.regex.*;
import java.util.*;
public class ExtractCurrencyValues {
    public static void main(String[] args) {
        String text = "The price is .99, and the discount is 10.50.";
        String regex = "\\True\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
