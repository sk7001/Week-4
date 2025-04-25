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
        for (Policy p : linkedHashSet) p.displayPolicy();
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

public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        Policy p1 = new Policy(1001, "Sobhit", "15-05-2025", "Auto", 15000);
        Policy p2 = new Policy(1002, "Santhi", "01-05-2025", "Life", 30000);
        Policy p3 = new Policy(1003, "Sridhar", "05-05-2025", "Home", 45000);
        Policy p4 = new Policy(1001, "Souji", "10-06-2025", "Auto", 18000);
        manager.addPolicy(p1); manager.addPolicy(p2); manager.addPolicy(p3); manager.addPolicy(p4);
        manager.displayAllPolicies();
        manager.showPoliciesExpiringSoon();
        manager.showPoliciesByCoverage("Life");
        manager.findPolicyByName("Sobhit");
        manager.showDuplicatePolicies();
        manager.performanceComparison(new Policy(9999, "Test", "01-01-2030", "Test", 1000));
    }
}
