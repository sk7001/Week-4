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
public class EmployeeSerializationDemo {
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
