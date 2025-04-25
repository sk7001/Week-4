import java.util.LinkedList;
import java.util.List;

public class ReverseListLinkedList {
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
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1); linkedList.add(2); linkedList.add(3); linkedList.add(4); linkedList.add(5);
        System.out.println("Original LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
