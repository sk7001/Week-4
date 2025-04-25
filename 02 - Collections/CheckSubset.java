import java.util.Set;
import java.util.HashSet;

public class CheckSubset {
    public static void main(String[] args) {
        Set<Integer> subset = new HashSet<>();
        subset.add(2); subset.add(3);
        Set<Integer> superset = new HashSet<>();
        superset.add(1); superset.add(2); superset.add(3); superset.add(4);
        boolean isSubset = superset.containsAll(subset);
        System.out.println("Is subset: " + isSubset);
    }
}
