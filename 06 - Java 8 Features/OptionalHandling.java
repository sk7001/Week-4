import java.util.*;
import java.util.Optional;
public class OptionalHandling {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 7, 3, 8, 12);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Max value: " + max.orElseThrow(() -> new NoSuchElementException("List is empty")));
    }
}
