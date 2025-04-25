import java.io.*;
import java.nio.file.*;
public class ImageByteArrayCopy {
    public static void main(String[] args) {
        try {
            byte[] imageBytes;
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                Files.copy(Paths.get("input.jpeg"), baos);
                imageBytes = baos.toByteArray();
            }
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes)) {
                Files.copy(bais, Paths.get("output.jpeg"), StandardCopyOption.REPLACE_EXISTING);
            }
            System.out.println("Copying image done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
