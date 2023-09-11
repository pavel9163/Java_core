import regular.Calculator;
import regular.Decorator;

public class Main {
    public static void main(String[] args) {
        int result = Calculator.add(2, 2);
        System.out.println(Decorator.decorator(result));
        result = Calculator.sub(2, 2);
        System.out.println(Decorator.decorator(result));
        result = Calculator.mul(2, 2);
        System.out.println(Decorator.decorator(result));
        result = Calculator.div(2, 2);
        System.out.println(Decorator.decorator(result));
    }
}
