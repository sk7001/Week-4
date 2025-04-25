import java.util.*;
import java.util.stream.*;
public class EmployeeDataProcessing {
    static class Employee {
        int id;
        String name;
        String department;
        double salary;
        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
        public String getName() { return name; }
    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 90000),
            new Employee(2, "Bob", "Engineering", 85000),
            new Employee(3, "Charlie", "HR", 70000),
            new Employee(4, "Dave", "Engineering", 75000)
        );
        Map<String, List<Employee>> grouped = employees.stream()
            .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .collect(Collectors.groupingBy(Employee::getDepartment));
        grouped.forEach((dept, emps) -> {
            System.out.println(dept + ": " + emps.stream().map(Employee::getName).collect(Collectors.toList()));
        });
        grouped.forEach((dept, emps) -> {
            double avg = emps.stream().mapToDouble(Employee::getSalary).average().orElse(0);
            System.out.println("Avg salary in " + dept + ": " + avg);
        });
    }
}
