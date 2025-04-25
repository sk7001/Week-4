import java.io.*;
public class StudentDataStreams {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"))) {
            dos.writeInt(101);
            dos.writeUTF("John");
            dos.writeDouble(3.8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println(roll + " " + name + " " + gpa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
