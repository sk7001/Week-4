import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class ConvertSetToSortedList {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(5); set1.add(6); set1.add(2); set1.add(1); set1.add(9);
        List<Integer> list = new ArrayList<>(set1);
        Collections.sort(list);
        System.out.print(list);
    }
}
