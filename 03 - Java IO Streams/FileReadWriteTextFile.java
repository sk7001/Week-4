import java.io.*;
public class FileReadWriteTextFile {
    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream("input.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            int byteData;
            while((byteData = fileInputStream.read())!=-1) {
                fileOutputStream.write(byteData);
            }
            System.out.println("File copied successfully");
            String line;
            while((line=reader.readLine())!=null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.print("Error occured: " + e);
        }
    }
}
