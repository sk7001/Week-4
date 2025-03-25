import java.util.*;
import java.util.stream.*;
public class MapAndReduceOperation {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfSquares = numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(n -> n * n)
            .reduce(0, Integer::sum);
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
