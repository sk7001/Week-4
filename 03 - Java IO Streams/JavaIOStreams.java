/*
Problem 1
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class JavaIOStreams{
	public static void main(String[] args) {
		try(FileInputStream fileInputStream = new FileInputStream("input.txt");
			FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
				BufferedReader reader = new BufferedReader(new FileReader("output.txt"))){
			int byteData;
			while((byteData = fileInputStream.read())!=-1) {
				fileOutputStream.write(byteData);
			}
			System.out.println("File copied successfully");
			String line;
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			System.out.print("Error occured: " + e);
		}
	}
}
*/

/*
Problem 2
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaIOStreams{
	public static void main(String[] args) {
		try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input.txt"));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("output.txt"));
			FileInputStream fileInputStream = new FileInputStream("input.txt");
			FileOutputStream fileOutputStream = new FileOutputStream("output.txt")){
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
			}catch(IOException e) {
			System.out.print("Error occured: " + e);
		}
	}
}
*/

/*
Problem 3
import java.io.*;

public class JavaIOStreams {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            writer = new FileWriter("user_info.txt");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            System.out.println("User information saved to user_info.txt");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
*/

/*
Problem 4
import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + department + " " + salary;
    }
}

public class JavaIOStreams {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            out.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> readList = (List<Employee>) in.readObject();
            for (Employee e : readList) System.out.println(e);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
*/


/*
Problem 5
import java.io.*;
import java.nio.file.*;

public class JavaIOStreams {
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
*/

/*
Problem 6
import java.io.*;

public class JavaIOStreams {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("Conversion successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/

/*
Problem 7
import java.io.*;

public class JavaIOStreams {
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
*/

/*
Problem 8
import java.io.*;

public class JavaIOStreams {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        Thread writer = new Thread(() -> {
            try {
                pos.write("Hello from writer thread!".getBytes());
                pos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread reader = new Thread(() -> {
            try {
                int data;
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        writer.start();
        reader.start();
    }
}
*/

/*
Problem 9
import java.io.*;

public class JavaIOStreams {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println("[ERROR] " + line);
                } else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/

/*
Problem 10
import java.io.*;
import java.util.*;

public class JavaIOStreams {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.toLowerCase().split("\\W+")) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
*/