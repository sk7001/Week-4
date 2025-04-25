import java.util.*;
import java.util.function.*;
public class ConsumerInterfaceDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "avocado", "kiwi");
        Consumer<String> printUppercase = s -> System.out.println(s.toUpperCase());
        strings.forEach(printUppercase);
    }
}
