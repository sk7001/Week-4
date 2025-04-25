/*
Problem 1
import java.util.*;
import java.util.stream.*;

public class Java8 {
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
*/

/*
Problem 2
import java.util.*;
import java.util.stream.*;

public class Java8 {
    static class Sale {
        String productId;
        int quantity;
        double price;

        public Sale(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }
    }

    static class ProductSales {
        String productId;
        double totalRevenue;

        public ProductSales(String productId, double totalRevenue) {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }

        public String toString() {
            return productId + ": $" + totalRevenue;
        }
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("A", 12, 10),
            new Sale("B", 5, 20),
            new Sale("C", 15, 5),
            new Sale("D", 20, 7)
        );

        List<ProductSales> result = sales.stream()
            .filter(s -> s.quantity > 10)
            .map(s -> new ProductSales(s.productId, s.quantity * s.price))
            .sorted(Comparator.comparingDouble(ps -> -ps.totalRevenue))
            .limit(5)
            .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
*/

/*
Problem 3
import java.util.*;
import java.util.stream.*;

public class Java8 {
    static class Book {
        String title, author, genre;
        double rating;

        public Book(String title, String author, String genre, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }
    }

    static class BookRecommendation {
        String title;
        double rating;

        public BookRecommendation(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }

        public String toString() {
            return title + " (" + rating + ")";
        }
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Author X", "Science Fiction", 4.5),
            new Book("Book B", "Author Y", "Science Fiction", 4.2),
            new Book("Book C", "Author Z", "Romance", 4.7)
        );

        List<BookRecommendation> result = books.stream()
            .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
            .map(b -> new BookRecommendation(b.title, b.rating))
            .sorted(Comparator.comparingDouble((BookRecommendation br) -> br.rating).reversed())
            .limit(10)
            .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
*/

/*
Problem 4
import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class Java8 {
    static class Claim {
        String claimId, policyNumber, status;
        double claimAmount;
        LocalDate claimDate;

        public Claim(String claimId, String policyNumber, double claimAmount, LocalDate claimDate, String status) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.claimDate = claimDate;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("C1", "P1", 6000, LocalDate.now(), "Approved"),
            new Claim("C2", "P1", 7000, LocalDate.now(), "Approved"),
            new Claim("C3", "P2", 12000, LocalDate.now(), "Rejected"),
            new Claim("C4", "P2", 10000, LocalDate.now(), "Approved")
        );

        Map<String, List<Claim>> grouped = claims.stream()
            .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
            .collect(Collectors.groupingBy(c -> c.policyNumber));

        grouped.forEach((policy, list) -> {
            double total = list.stream().mapToDouble(c -> c.claimAmount).sum();
            double avg = list.stream().mapToDouble(c -> c.claimAmount).average().orElse(0);
            System.out.println(policy + " -> Total: " + total + ", Avg: " + avg);
        });

        grouped.entrySet().stream()
            .sorted((a, b) -> Double.compare(
                b.getValue().stream().mapToDouble(c -> c.claimAmount).sum(),
                a.getValue().stream().mapToDouble(c -> c.claimAmount).sum()
            ))
            .limit(3)
            .forEach(e -> System.out.println("Top Policy: " + e.getKey()));
    }
}
*/

/*
Problem 5
import java.util.*;
import java.util.stream.*;

public class Java8 {
    static class PolicyHolder {
        String holderId, name, policyType;
        int age;
        double premiumAmount;

        public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
            this.holderId = holderId;
            this.name = name;
            this.age = age;
            this.policyType = policyType;
            this.premiumAmount = premiumAmount;
        }
    }

    static class RiskAssessment {
        String holderId, name, category;
        double riskScore;

        public RiskAssessment(String holderId, String name, double riskScore) {
            this.holderId = holderId;
            this.name = name;
            this.riskScore = riskScore;
            this.category = riskScore > 0.5 ? "High Risk" : "Low Risk";
        }

        public String toString() {
            return name + " (" + category + ")";
        }
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder("H1", "John", 65, "Life", 40000),
            new PolicyHolder("H2", "Jane", 70, "Life", 30000),
            new PolicyHolder("H3", "Mike", 50, "Health", 25000)
        );

        List<RiskAssessment> result = holders.stream()
            .filter(h -> h.policyType.equals("Life") && h.age > 60)
            .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
            .sorted(Comparator.comparingDouble((RiskAssessment r) -> -r.riskScore))
            .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
*/

/*
Problem 6
import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class Java8 {
    static class Transaction {
        String transactionId, policyNumber;
        double amount;
        LocalDate transactionDate;
        boolean isFraudulent;

        public Transaction(String transactionId, String policyNumber, double amount, LocalDate transactionDate, boolean isFraudulent) {
            this.transactionId = transactionId;
            this.policyNumber = policyNumber;
            this.amount = amount;
            this.transactionDate = transactionDate;
            this.isFraudulent = isFraudulent;
        }

        public String getPolicyNumber() { return policyNumber; }
        public double getAmount() { return amount; }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", "P1", 20000, LocalDate.now(), true),
            new Transaction("T2", "P1", 30000, LocalDate.now(), true),
            new Transaction("T3", "P1", 10000, LocalDate.now(), false),
            new Transaction("T4", "P2", 50000, LocalDate.now(), false)
        );

        Map<String, Double> totalAmountByPolicy = transactions.stream()
            .filter(t -> !t.isFraudulent)
            .collect(Collectors.groupingBy(Transaction::getPolicyNumber, Collectors.summingDouble(Transaction::getAmount)));

        totalAmountByPolicy.forEach((policy, total) -> {
            System.out.println(policy + ": $" + total);
        });
    }
}
*/

// Problem Statements
/*
Problem 1
import java.util.function.*;

public class Java8 {
    public static void main(String[] args) {
        interface Sum {
            int calculate(int a, int b);
        }

        Sum sum = (a, b) -> a + b;

        System.out.println("Sum: " + sum.calculate(5, 10));
    }
}
*/

/*
Problem 2
import java.util.*;
import java.util.stream.*;

public class Java8 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot");

        List<String> filtered = strings.stream()
            .filter(s -> s.startsWith("A"))
            .collect(Collectors.toList());

        filtered.forEach(System.out::println);
    }
}
*/

/*
Problem 3
import java.util.*;
import java.util.stream.*;

public class Java8 {
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
*/

/*
Problem 4
import java.util.*;
import java.util.stream.*;

public class Java8 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfSquares = numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(n -> n * n)
            .reduce(0, Integer::sum);

        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
*/

/*
Problem 5
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Java8 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "avocado", "kiwi");

        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> lengthGreaterThanFive = s -> s.length() > 5;

        words.stream()
            .filter(startsWithA.and(lengthGreaterThanFive))
            .forEach(System.out::println);
    }
}
*/

/*
Problem 6
import java.util.*;
import java.util.function.*;

public class Java8 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "avocado", "kiwi");

        Consumer<String> printUppercase = s -> System.out.println(s.toUpperCase());

        strings.forEach(printUppercase);
    }
}
*/

/*
Problem 7
import java.util.function.*;

public class Java8 {
    public static void main(String[] args) {
        Function<Double, Double> calculateArea = r -> Math.PI * r * r;

        System.out.println("Area of the circle: " + calculateArea.apply(5.0));
    }
}
*/

/*
Problem 8
import java.util.function.*;

public class Java8 {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;

        System.out.println(concatenate.apply("Hello", "World"));
    }
}
*/

/*
Problem 9
import java.util.function.*;

public class Java8 {
    interface Square {
        int calculate(int a);

        default void printMessage() {
            System.out.println("Calculating the square:");
        }
    }

    public static void main(String[] args) {
        Square square = a -> a * a;

        square.printMessage();
        System.out.println("Square of 4: " + square.calculate(4));
    }
}
*/

/*
Problem 10
import java.util.*;
import java.util.Optional;

public class Java8 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 7, 3, 8, 12);

        Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        System.out.println("Max value: " + max.orElseThrow(() -> new NoSuchElementException("List is empty")));
    }
}
*/

/*
Problem 11 (Insurance)
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.*;
import java.util.regex.*;
import java.util.Map.Entry;

public class InsuranceApp {
    static class Policy {
        String policyNumber;
        String holderName;
        double premiumAmount;

        public Policy(String policyNumber, String holderName, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.holderName = holderName;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() { return policyNumber; }
        public String getHolderName() { return holderName; }
        public double getPremiumAmount() { return premiumAmount; }

        @Override
        public String toString() {
            return "Policy{" + "policyNumber='" + policyNumber + "', holderName='" + holderName + "', premiumAmount=" + premiumAmount + '}';
        }
    }

    public static void main(String[] args) throws IOException {
        List<Policy> policies = Arrays.asList(
            new Policy("P001", "John Doe", 1500),
            new Policy("P002", "Jane Smith", 2500),
            new Policy("P003", "Alice Johnson", 800),
            new Policy("P004", "Bob Brown", 1800),
            new Policy("P005", "Charlie White", 2200)
        );

        List<Policy> highPremiumPolicies = policies.stream()
            .filter(p -> p.getPremiumAmount() > 1200)
            .collect(Collectors.toList());
        System.out.println("Policies with premium > 1200: " + highPremiumPolicies);

        List<Policy> sortedByHolderName = policies.stream()
            .sorted(Comparator.comparing(Policy::getHolderName))
            .collect(Collectors.toList());
        System.out.println("Policies sorted by holder name: " + sortedByHolderName);

        double totalPremium = policies.stream()
            .mapToDouble(Policy::getPremiumAmount)
            .sum();
        System.out.println("Total Premium: " + totalPremium);

        policies.forEach(p -> System.out.println(p));

        List<Policy> premiumRangePolicies = policies.stream()
            .filter(p -> p.getPremiumAmount() > 1000 && p.getPremiumAmount() < 2000)
            .collect(Collectors.toList());
        System.out.println("Policies with premium between 1000 and 2000: " + premiumRangePolicies);

        Optional<Policy> maxPremiumPolicy = policies.stream()
            .max(Comparator.comparingDouble(Policy::getPremiumAmount));
        System.out.println("Policy with highest premium: " + maxPremiumPolicy.orElse(null));

        Map<Character, List<Policy>> groupedByInitial = policies.stream()
            .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));
        System.out.println("Policies grouped by holder name initial: " + groupedByInitial);

        double averagePremium = policies.stream()
            .mapToDouble(Policy::getPremiumAmount)
            .average()
            .orElse(0);
        System.out.println("Average Premium: " + averagePremium);

        List<Policy> sortedByPremium = policies.stream()
            .sorted(Comparator.comparingDouble(Policy::getPremiumAmount))
            .collect(Collectors.toList());
        System.out.println("Policies sorted by premium: " + sortedByPremium);

        boolean anyExceeds2000 = policies.stream()
            .anyMatch(p -> p.getPremiumAmount() > 2000);
        System.out.println("Any policy exceeds 2000: " + anyExceeds2000);

        Map<String, Long> countByPremiumRange = policies.stream()
            .collect(Collectors.groupingBy(p -> {
                if (p.getPremiumAmount() <= 1000) return "$0-$1,000";
                else if (p.getPremiumAmount() <= 2000) return "$1,001-$2,000";
                else return ">$2,000";
            }, Collectors.counting()));
        System.out.println("Count of policies in each premium range: " + countByPremiumRange);

        Set<String> uniqueHolderNames = policies.stream()
            .map(Policy::getHolderName)
            .collect(Collectors.toSet());
        System.out.println("Unique holder names: " + uniqueHolderNames);

        List<Policy> policiesWithSmith = policies.stream()
            .filter(p -> p.getHolderName().contains("Smith"))
            .collect(Collectors.toList());
        System.out.println("Policies with 'Smith' in holder name: " + policiesWithSmith);

        Map<String, Double> policyNumberToPremium = policies.stream()
            .collect(Collectors.toMap(Policy::getPolicyNumber, Policy::getPremiumAmount));
        System.out.println("Map of Policy Number to Premium: " + policyNumberToPremium);

        String text = "hello world, hello hello world, java stream api hello world java";
        List<String> mostFrequentWords = getTopNFrequentWords(text, 2);
        System.out.println("Top 2 most frequent words: " + mostFrequentWords);

        String secondMostRepeatedWord = getSecondMostRepeatedWord(text);
        System.out.println("Second most repeated word: " + secondMostRepeatedWord);
    }

    public static List<String> getTopNFrequentWords(String text, int topN) {
        return Arrays.stream(text.split("\\W+"))
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
            .entrySet().stream()
            .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
            .limit(topN)
            .map(Entry::getKey)
            .collect(Collectors.toList());
    }

    public static String getSecondMostRepeatedWord(String text) {
        return Arrays.stream(text.split("\\W+"))
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
            .entrySet().stream()
            .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
            .skip(1)
            .findFirst()
            .map(Entry::getKey)
            .orElse("No second most frequent word");
    }
}
*/