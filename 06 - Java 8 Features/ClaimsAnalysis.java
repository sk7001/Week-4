import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;
public class ClaimsAnalysis {
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
