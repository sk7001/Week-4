import java.util.HashSet;

public class CheckIfTwoSetsAreEqual {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1); set1.add(2); set1.add(3);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3); set2.add(2); set2.add(1);
        System.out.println("Are both sets equal? " + set1.equals(set2));
    }
}
