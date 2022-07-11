package lambda;

import java.util.function.*;

public class Lambda {
    public static String methodOne(ZeroArgsFunctionalInterface zeroInterface) {
        return zeroInterface.zeroArgsMethod();
    }

    public static double methodTwo(double a, OneArgFunctionalInterface oneInterface) {
        return oneInterface.oneArgMethod(a);
    }

    public static double methodThree(double a, double b, TwoArgsFunctionalInterface twoInterface) {
        return twoInterface.twoArgsMethod(a, b);
    }

    public static String methodFunction(String a, Function<String, String> function) {
        return function.apply(a);
    }

    public static Integer methodIntSupplier(IntSupplier intSupplier) {
        return intSupplier.getAsInt();
    }

    public static void methodConsumer(Consumer consumer) {
        consumer.accept("Cons");
    }

    public static boolean methodPredicate(String a, Predicate<String> b) {
        return b.test(a);
    }
}
