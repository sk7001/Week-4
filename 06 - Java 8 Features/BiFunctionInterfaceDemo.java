import java.util.function.*;
public class BiFunctionInterfaceDemo {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;
        System.out.println(concatenate.apply("Hello", "World"));
    }
}
