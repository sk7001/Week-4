import java.util.regex.*;
public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String sentence = "This  is    an example   with multiple    spaces.";
        String regex = "\\s+";
        String result = sentence.replaceAll(regex, " ");
        System.out.println(result);
    }
}
