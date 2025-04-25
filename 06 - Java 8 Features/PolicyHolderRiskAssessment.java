import java.util.*;
import java.util.stream.*;
public class PolicyHolderRiskAssessment {
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
