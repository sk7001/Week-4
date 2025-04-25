import java.util.ArrayList;
import java.util.List;

public class ReverseListArrayList {
    public static void reverseList(List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1); arrayList.add(2); arrayList.add(3); arrayList.add(4); arrayList.add(5);
        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);
    }
}
