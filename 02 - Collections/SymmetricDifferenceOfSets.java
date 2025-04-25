import java.util.HashSet;
import java.util.Set;

public class SymmetricDifferenceOfSets {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1); set1.add(2); set1.add(3); set1.add(4); set1.add(5);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(4); set2.add(9); set2.add(2);
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        union.removeAll(intersection);
        System.out.println("Symmetric Difference: " + union);
    }
}
