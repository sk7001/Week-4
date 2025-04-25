import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;
public class FraudDetection {
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
