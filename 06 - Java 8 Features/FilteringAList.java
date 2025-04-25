import java.util.*;
import java.util.stream.*;
public class FilteringAList {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot");
        List<String> filtered = strings.stream()
            .filter(s -> s.startsWith("A"))
            .collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }
}
