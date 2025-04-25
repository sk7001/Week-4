import java.util.function.*;
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<Double, Double> calculateArea = r -> Math.PI * r * r;
        System.out.println("Area of the circle: " + calculateArea.apply(5.0));
    }
}
