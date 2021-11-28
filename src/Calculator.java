import java.util.function.*;

public class Calculator {

    static Supplier <Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    //BinaryOperator<Integer> divide = (x, y) -> x / y;
    // Ошибка в том, что возникает ArithmeticException: division by zero;
    // Возможно исправить использованием BiFunction, с выдачей результата в виде String
    // А возможно использовать перехват ArithmeticException, чем и воспользуюсь
    BinaryOperator<Integer> divide = (x, y) -> {
        try {
            if (y == 0) throw new ArithmeticException("Division by zero");
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    };

    UnaryOperator <Integer> pow = x -> x * x;
    UnaryOperator <Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate <Integer> isPositive = x -> x > 0;

    Consumer <Integer> println = System.out::println;
}
