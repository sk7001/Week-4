//List Interface
/*
Problem 1
import java.util.List;

public class Collections {
    public static void reverseList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        
        while (left < right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            
            left++;
            right--;
        }
    }
	public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("Original ArrayList: " + arrayList);
        
        reverseList(arrayList);
        
        System.out.println("Reversed ArrayList: " + arrayList);
    }
}

import java.util.LinkedList;
import java.util.List;

public class Collections {
	public static void reverseList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        
        while (left < right) {
            Integer temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println("Original LinkedList: " + linkedList);
        
        reverseList(linkedList);
        
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}

*/

/*
Problem 2 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collections {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");

        Map<String, Integer> frequencyMap = findFrequency(fruits);

        System.out.println("Frequency of elements: " + frequencyMap);
    }

    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String item : list) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        return map;
    }
}
*/

/*
Problem 3
import java.util.List;
import java.util.ArrayList;

public class Collections {
    public static void rotateList(List<Integer> list, int positions) {
        int size = list.size();
        if (size == 0 || positions % size == 0) {
            return;
        }

        positions = positions % size;

        List<Integer> rotated = new ArrayList<>();

        for (int i = positions; i < size; i++) {
            rotated.add(list.get(i));
        }

        for (int i = 0; i < positions; i++) {
            rotated.add(list.get(i));
        }

        for (int i = 0; i < size; i++) {
            list.set(i, rotated.get(i));
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Original List: " + list);

        rotateList(list, 2);

        System.out.println("Rotated List: " + list);
    }
}
*/

/*
 * Problem 4
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Collections {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : list) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Original List: " + list);

        List<Integer> result = removeDuplicates(list);

        System.out.println("List After Removing Duplicates: " + result);
    }
}
*/


//Set Interface
/*
Problem 1
import java.util.HashSet;

public class Collections{
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		HashSet<Integer> set2 = new HashSet<>();
		set2.add(3);
		set2.add(2);
		set2.add(1);
		
		System.out.println("Is both the set same ?, " + set1.equals(set2));;
	}
}
*/

/*
Problem 2
import java.util.HashSet;
import java.util.Set;

public class Collections{
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		
		HashSet<Integer> set2 = new HashSet<>();
		set2.add(4);
		set2.add(9);
		set2.add(2);
		
		Set<Integer> union = new HashSet<>(set1);
		union.addAll(set2);
		
		Set<Integer> intersection = new HashSet<>(set1);
		intersection.retainAll(set2);
		
		System.out.println(union);;
		System.out.println(intersection);;
	}
}
*/

/*
Problem 3
import java.util.HashSet;
import java.util.Set;

public class Collections{
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		
		HashSet<Integer> set2 = new HashSet<>();
		set2.add(4);
		set2.add(9);
		set2.add(2);
		
		Set<Integer> union = new HashSet<>(set1);
		union.addAll(set2);
		
		Set<Integer> intersection = new HashSet<>(set1);
		intersection.retainAll(set2);

		union.removeAll(intersection);
		System.out.println(union);;
	}
}
*/

/*
Problem 4
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class collections{
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(5);
		set1.add(6);
		set1.add(2);
		set1.add(1);
		set1.add(9);
		
		List<Integer> list = new ArrayList<>(set1);
		Collections.sort(list);
		System.out.print(list);
	}
}
*/

/*
Problem 5
import java.util.Set;
import java.util.HashSet;

public class collections {
    public static void main(String[] args) {
        Set<Integer> subset = new HashSet<>();
        subset.add(2);
        subset.add(3);

        Set<Integer> superset = new HashSet<>();
        superset.add(1);
        superset.add(2);
        superset.add(3);
        superset.add(4);

        boolean isSubset = superset.containsAll(subset);

        System.out.println("Is subset: " + isSubset);
    }
}
*/

/*
Problem: Insurance Policy Management System
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Policy implements Comparable<Policy> {
    int policyNumber, amount;
    String policyHolder, coverageType;
    LocalDate expiryDate;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    Policy(int policyNumber, String policyHolder, String expiryDate, String coverageType, int amount) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = LocalDate.parse(expiryDate, formatter);
        this.coverageType = coverageType;
        this.amount = amount;
    }

    void displayPolicy() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Policyholder Name: " + policyHolder);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Coverage Type: " + coverageType);
        System.out.println("Premium Amount: " + amount);
        System.out.println();
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return this.policyNumber == other.policyNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}

class PolicyManager {
    HashSet<Policy> hashSet = new HashSet<>();
    LinkedHashSet<Policy> linkedHashSet = new LinkedHashSet<>();
    TreeSet<Policy> treeSet = new TreeSet<>();
    HashMap<Integer, Integer> policyCount = new HashMap<>();

    boolean addPolicy(Policy p) {
        policyCount.put(p.policyNumber, policyCount.getOrDefault(p.policyNumber, 0) + 1);
        boolean added = hashSet.add(p);
        if (added) {
            linkedHashSet.add(p);
            treeSet.add(p);
        }
        return added;
    }

    void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        for (Policy p : linkedHashSet) {
            p.displayPolicy();
        }
    }

    void showPoliciesExpiringSoon() {
        System.out.println("Policies Expiring Within 30 Days:");
        LocalDate now = LocalDate.now();
        for (Policy p : treeSet) {
            if (!p.expiryDate.isBefore(now) && p.expiryDate.isBefore(now.plusDays(30))) {
                p.displayPolicy();
            }
        }
    }

    void showPoliciesByCoverage(String type) {
        System.out.println("Policies with Coverage Type: " + type);
        for (Policy p : linkedHashSet) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                p.displayPolicy();
            }
        }
    }

    void findPolicyByName(String name) {
        System.out.println("Searching for Policyholder: " + name);
        boolean found = false;
        for (Policy p : hashSet) {
            if (p.policyHolder.equalsIgnoreCase(name)) {
                p.displayPolicy();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policy found for: " + name);
        }
    }

    void showDuplicatePolicies() {
        System.out.println("Duplicate Policies Detected (by Policy Number):");
        boolean found = false;
        for (Map.Entry<Integer, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number " + entry.getKey() + " appears " + entry.getValue() + " times.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No duplicate policy numbers found.");
        }
    }

    void performanceComparison(Policy samplePolicy) {
        System.out.println("\nPerformance Comparison (Add, Search, Remove):");

        long start, end;

        HashSet<Policy> hs = new HashSet<>();
        start = System.nanoTime(); hs.add(samplePolicy); end = System.nanoTime();
        System.out.println("HashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime(); hs.contains(samplePolicy); end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime(); hs.remove(samplePolicy); end = System.nanoTime();
        System.out.println("HashSet Remove Time: " + (end - start) + " ns");

        LinkedHashSet<Policy> lhs = new LinkedHashSet<>();
        start = System.nanoTime(); lhs.add(samplePolicy); end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime(); lhs.contains(samplePolicy); end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime(); lhs.remove(samplePolicy); end = System.nanoTime();
        System.out.println("LinkedHashSet Remove Time: " + (end - start) + " ns");

        TreeSet<Policy> ts = new TreeSet<>();
        start = System.nanoTime(); ts.add(samplePolicy); end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime(); ts.contains(samplePolicy); end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime(); ts.remove(samplePolicy); end = System.nanoTime();
        System.out.println("TreeSet Remove Time: " + (end - start) + " ns");
    }
}

public class collections {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy(1001, "Sobhit", "15-05-2025", "Auto", 15000);
        Policy p2 = new Policy(1002, "Santhi", "01-05-2025", "Life", 30000);
        Policy p3 = new Policy(1003, "Sridhar", "05-05-2025", "Home", 45000);
        Policy p4 = new Policy(1001, "Souji", "10-06-2025", "Auto", 18000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

        manager.displayAllPolicies();
        manager.showPoliciesExpiringSoon();
        manager.showPoliciesByCoverage("Life");
        manager.findPolicyByName("Sobhit");
        manager.showDuplicatePolicies();

        manager.performanceComparison(new Policy(9999, "Test", "01-01-2030", "Test", 1000));
    }
}
*/

//Queue Interface
/*
Problem 1
import java.util.*;

class collections {
    public static Queue<Integer> reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) return queue;
        int front = queue.remove();
        reverse(queue);
        queue.add(front);
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println("Original: " + q);
        reverse(q);
        System.out.println("Reversed: " + q);
    }
}
*/

/*
Problem 2 
import java.util.*;

class collections{
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String current = q.remove();
            result.add(current);
            q.add(current + "0");
            q.add(current + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 10;
        List<String> binaries = generateBinaryNumbers(N);
        System.out.println("First " + N + " binary numbers: " + binaries);
    }
}
*/

/*
Problem 3 
import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

class collections {
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}
*/

/*
Problem 4 
import java.util.*;

class collections {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) q2.add(q1.remove());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop() {
        if (q1.isEmpty()) throw new NoSuchElementException();
        return q1.remove();
    }

    int top() {
        if (q1.isEmpty()) throw new NoSuchElementException();
        return q1.peek();
    }

    boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
       collections stack = new collections();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top after pop: " + stack.top());
    }
}
*/

/*
Problem 5
class collections {
    int[] buffer;
    int size, start, end, count;

    collections(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        start = 0;
        end = 0;
        count = 0;
    }

    void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % size;
        if (count == size) {
            start = (start + 1) % size;
        } else {
            count++;
        }
    }

    void printBuffer() {
        int idx = start;
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[idx] + " ");
            idx = (idx + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
    	collections cb = new collections(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer();
        cb.insert(4);
        cb.printBuffer();
    }
}
*/

//Map Interface
/*
Problem 1
import java.util.*;

public class collections {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] words = text.split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println(freqMap);
    }
}
*/

/*
Problem 2
import java.util.*;

public class collections {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 1);
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println(inverted);
    }
}
*/

/*
Problem 3
import java.util.*;

public class collections {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 10, "B", 20, "C", 15);
        String maxKey = "";
        int maxVal = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        System.out.println("Key with max value: " + maxKey);
    }
}
*/

/*
Problem 4
import java.util.*;

public class collections {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            map1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        System.out.println(map1);
    }
}
*/

/*
Problem 5
import java.util.*;

class Employee {
    String name, department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class collections {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee e : employees) {
            grouped.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }

        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
*/

// 1. Insurance Policy Management System
/*
import java.util.*;
import java.time.LocalDate;

class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;

    Policy(String number, String holder, LocalDate expiry) {
        this.policyNumber = number;
        this.policyHolder = holder;
        this.expiryDate = expiry;
    }

    public String toString() {
        return policyNumber + " - " + policyHolder + " (Expires: " + expiryDate + ")";
    }
}

class collections {
    HashMap<String, Policy> hashMap = new HashMap<>();
    LinkedHashMap<String, Policy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);

        treeMap.putIfAbsent(policy.expiryDate, new ArrayList<>());
        treeMap.get(policy.expiryDate).add(policy);
    }

    Policy getPolicyByNumber(String number) {
        return hashMap.get(number);
    }

    List<Policy> getExpiringIn30Days() {
        List<Policy> result = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(30);
        for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.headMap(threshold, true).entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    List<Policy> getPoliciesByHolder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(holder)) {
                result.add(policy);
            }
        }
        return result;
    }

    void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Policy> entry = it.next();
            if (entry.getValue().expiryDate.isBefore(now)) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        collections system = new collections();
        system.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy("P103", "Alice", LocalDate.now().minusDays(5)));

        System.out.println("Policy by number P101: " + system.getPolicyByNumber("P101"));
        System.out.println("Policies expiring in 30 days: " + system.getExpiringIn30Days());
        System.out.println("Policies by Alice: " + system.getPoliciesByHolder("Alice"));

        system.removeExpiredPolicies();
        System.out.println("Policies after removing expired: " + system.hashMap.values());
    }
}
*/

// Voting System
/*
import java.util.*;

class collections {
    public static void main(String[] args) {
        HashMap<String, Integer> voteMap = new HashMap<>();
        LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

        vote("Alice", voteMap, voteOrder);
        vote("Bob", voteMap, voteOrder);
        vote("Alice", voteMap, voteOrder);
        vote("Charlie", voteMap, voteOrder);
        vote("Bob", voteMap, voteOrder);

        System.out.println("Vote Order: " + voteOrder);

        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteMap);
        System.out.println("Sorted Vote Results: " + sortedVotes);
    }

    static void vote(String candidate, Map<String, Integer> voteMap, Map<String, Integer> voteOrder) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteMap.get(candidate));
    }
}
*/


// Shopping Cart
/*
import java.util.*;

class collections {
    public static void main(String[] args) {
        HashMap<String, Integer> productPrices = new HashMap<>();
        productPrices.put("Apple", 100);
        productPrices.put("Banana", 40);
        productPrices.put("Orange", 70);

        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Apple", 2);
        cart.put("Banana", 5);
        cart.put("Orange", 3);

        TreeMap<Integer, List<String>> sortedByPrice = new TreeMap<>();
        for (String product : cart.keySet()) {
            int price = productPrices.get(product);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }

        System.out.println("Cart Items in Order Added: " + cart);
        System.out.println("Cart Items Sorted by Price: " + sortedByPrice);
    }
}
*/

// Banking System
/*
import java.util.*;

class collections {
    public static void main(String[] args) {
        HashMap<Integer, Integer> accounts = new HashMap<>();
        accounts.put(101, 5000);
        accounts.put(102, 7000);
        accounts.put(103, 3000);

        TreeMap<Integer, List<Integer>> balanceMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : accounts.entrySet()) {
            int balance = entry.getValue();
            balanceMap.putIfAbsent(balance, new ArrayList<>());
            balanceMap.get(balance).add(entry.getKey());
        }

        Queue<Integer> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add(101);
        withdrawalQueue.add(103);

        while (!withdrawalQueue.isEmpty()) {
            int acc = withdrawalQueue.poll();
            if (accounts.containsKey(acc)) {
                int bal = accounts.get(acc);
                accounts.put(acc, bal - 500);
            }
        }

        System.out.println("Final Account Balances: " + accounts);
        System.out.println("Accounts Sorted by Balance: " + balanceMap);
    }
}
*/