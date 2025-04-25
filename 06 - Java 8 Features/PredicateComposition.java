import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class PredicateComposition {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "avocado", "kiwi");
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> lengthGreaterThanFive = s -> s.length() > 5;
        words.stream()
            .filter(startsWithA.and(lengthGreaterThanFive))
            .forEach(System.out::println);
    }
}
