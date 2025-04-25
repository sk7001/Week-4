import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
class FileProcessorTest {
   FileProcessor fp = new FileProcessor();
   String filename = "testfile.txt";
   @Test
   void testWriteAndRead() throws IOException {
       fp.writeToFile(filename, "Hello");
       String content = fp.readFromFile(filename);
       assertEquals("Hello", content);
   }
   @Test
   void testFileExistsAfterWrite() throws IOException {
       fp.writeToFile(filename, "Data");
       File file = new File(filename);
       assertTrue(file.exists());
   }
   @Test
   void testReadNonExistingFileThrowsException() {
       assertThrows(IOException.class, () -> {
           fp.readFromFile("nonexistent.txt");
       });
   }
}
