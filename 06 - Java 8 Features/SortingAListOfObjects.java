import java.util.*;
import java.util.stream.*;
public class SortingAListOfObjects {
    static class Person {
        String name;
        int age;
        double salary;
        public Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
        public int getAge() { return age; }
        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("John", 28, 50000),
            new Person("Alice", 25, 60000),
            new Person("Bob", 30, 55000)
        );
        people.stream()
            .sorted(Comparator.comparingInt(Person::getAge))
            .forEach(System.out::println);
    }
}
