import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicatesPreserveOrder {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (Integer num : list) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3); list.add(1); list.add(2); list.add(2); list.add(3); list.add(4);
        System.out.println("Original List: " + list);
        List<Integer> result = removeDuplicates(list);
        System.out.println("List After Removing Duplicates: " + result);
    }
}
