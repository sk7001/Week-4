import java.util.regex.*;
public class CensorBadWords {
    public static void main(String[] args) {
        String sentence = "This is a damn bad example with some stupid words.";
        String regex = "(?i)\\b(damn|stupid)\\b";
        String result = sentence.replaceAll(regex, "****");
        System.out.println(result);
    }
}
