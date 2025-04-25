import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
class ListManagerTest {
   ListManager manager = new ListManager();
   @Test
   void testAddElement() {
       List<Integer> list = new ArrayList<>();
       manager.addElement(list, 5);
       assertTrue(list.contains(5));
   }
   @Test
   void testRemoveElement() {
       List<Integer> list = new ArrayList<>();
       list.add(10);
       manager.removeElement(list, 10);
       assertFalse(list.contains(10));
   }
   @Test
   void testGetSize() {
       List<Integer> list = new ArrayList<>();
       list.add(1);
       list.add(2);
       assertEquals(2, manager.getSize(list));
   }
}
