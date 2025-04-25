import java.util.List;
import java.util.ArrayList;

public class RotateElementsInList {
    public static void rotateList(List<Integer> list, int positions) {
        int size = list.size();
        if (size == 0 || positions % size == 0) return;
        positions = positions % size;
        List<Integer> rotated = new ArrayList<>();
        for (int i = positions; i < size; i++) rotated.add(list.get(i));
        for (int i = 0; i < positions; i++) rotated.add(list.get(i));
        for (int i = 0; i < size; i++) list.set(i, rotated.get(i));
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10); list.add(20); list.add(30); list.add(40); list.add(50);
        System.out.println("Original List: " + list);
        rotateList(list, 2);
        System.out.println("Rotated List: " + list);
    }
}
