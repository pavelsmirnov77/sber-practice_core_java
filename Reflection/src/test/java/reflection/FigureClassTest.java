package reflection;

import java.lang.reflect.*;
import org.junit.Test;
import java.util.Arrays;

public class FigureClassTest {
    private static final FigureClass PUBLIC_SQUARE = new FigureClass("Квадрат", 3.6);
    private static final Class<?> GET_MY_CLASS = PUBLIC_SQUARE.getClass();

    @Test
    public void fieldTest() throws IllegalAccessException, NoSuchFieldException {
        Field privateNameSquare = GET_MY_CLASS.getDeclaredField("nameSquare");
        privateNameSquare.setAccessible(true);
        privateNameSquare.set(PUBLIC_SQUARE, "Квадратище");
        System.out.println((String) privateNameSquare.get(PUBLIC_SQUARE));
        System.out.println(GET_MY_CLASS.getDeclaredField("side").getName());
        System.out.println(GET_MY_CLASS.getDeclaredField("color").getType());
    }

    @Test
    public void methodsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method privateMethod = GET_MY_CLASS.getDeclaredMethod("calculateArea");
        privateMethod.setAccessible(true);
        System.out.println(privateMethod.invoke(PUBLIC_SQUARE));
        System.out.println(Arrays.toString(GET_MY_CLASS.getSuperclass().getDeclaredMethods()));
        System.out.println(Arrays.toString(privateMethod.getExceptionTypes()));
    }

    @Test
    public void constructorsTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<FigureClass> publicConstructorFigure = FigureClass.class.getDeclaredConstructor(String.class, double.class);
        System.out.println(publicConstructorFigure);

        Constructor<FigureClass> privateConstructorFigure = FigureClass.class.getDeclaredConstructor(String.class, String.class, double.class);
        privateConstructorFigure.setAccessible(true);
        FigureClass privateFigure = privateConstructorFigure.newInstance("Квадрат", "черный", 4.2);
        System.out.println(privateFigure instanceof FigureClass);

        System.out.println(Arrays.toString(publicConstructorFigure.getParameterTypes()));
    }
}
