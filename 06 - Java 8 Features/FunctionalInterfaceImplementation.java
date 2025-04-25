public class FunctionalInterfaceImplementation {
    public static void main(String[] args) {
        interface Sum {
            int calculate(int a, int b);
        }
        Sum sum = (a, b) -> a + b;
        System.out.println("Sum: " + sum.calculate(5, 10));
    }
}
