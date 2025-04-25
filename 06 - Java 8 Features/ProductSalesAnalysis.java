import java.util.*;
import java.util.stream.*;
public class ProductSalesAnalysis {
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
