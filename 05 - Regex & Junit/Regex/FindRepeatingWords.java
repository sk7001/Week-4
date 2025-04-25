import java.util.regex.*;
import java.util.*;
public class FindRepeatingWords {
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        Set<String> seen = new HashSet<>();
        while (matcher.find()) {
            seen.add(matcher.group());
        }
        for (String word : seen) {
            System.out.println(word);
        }
    }
}
