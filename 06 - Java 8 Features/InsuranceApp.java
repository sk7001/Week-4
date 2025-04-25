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
                if (p.getPremiumAmount() <= 1000) return "-,000";
                else if (p.getPremiumAmount() <= 2000) return ",001-,000";
                else return ">,000";
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
