import java.io.*;
public class BufferedStreamsEfficientCopy {
    public static void main(String[] args) {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input.txt"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("output.txt"));
            FileInputStream fileInputStream = new FileInputStream("input.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt")) {
            byte[] buffer = new byte[4096];
            int byteData;
            long startBuffer = System.nanoTime();
            while((byteData=bufferedInputStream.read(buffer))!=-1) {
                bufferedOutputStream.write(buffer, 0, byteData);
            }
            long stopBuffer = System.nanoTime();
            System.out.println("BufferSTreams: Copied Successfully");
            System.out.println("Time taken for buffer is " + (stopBuffer - startBuffer));
            startBuffer = System.nanoTime();
            while((byteData=fileInputStream.read())!=-1) {
                fileOutputStream.write(byteData);
            }
            stopBuffer = System.nanoTime();
            System.out.println("FileStreams: Copied Successfully");
            System.out.println("Time taken for buffer is " + (stopBuffer - startBuffer));
        } catch(IOException e) {
            System.out.print("Error occured: " + e);
        }
    }
}
