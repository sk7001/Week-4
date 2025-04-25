public class CustomFunctionalInterfaceWithDefaultMethod {
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
