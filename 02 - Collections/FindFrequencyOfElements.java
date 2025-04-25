import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequencyOfElements {
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return map;
    }
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple"); fruits.add("banana"); fruits.add("apple"); fruits.add("orange");
        Map<String, Integer> frequencyMap = findFrequency(fruits);
        System.out.println("Frequency of elements: " + frequencyMap);
    }
}
