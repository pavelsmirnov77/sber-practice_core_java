package annotation;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomAnnotationTest {
    @CustomAnnotation(command = "printFirstMessage", queueNumber = 1)
    public String printFirstMessage() {
        return "Сработал первый метод";
    }

    @CustomAnnotation(command = "printSecondMessage", queueNumber = 2)
    public String printSecondMessage() {
        return "Сработал второй метод";
    }

    @CustomAnnotation(command = "printThirdMessage", queueNumber = 3)
    public String printThirdMessage() {
        return "Сработал третий метод";
    }

    public Map<Method, Integer> mapCreate() {
        return Arrays.stream(this
                .getClass()
                .getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(CustomAnnotation.class))
                .collect(Collectors.toMap(Function.identity(), value -> value.getAnnotation(CustomAnnotation.class).queueNumber()));
    }

    public void usedMapCreated(Method method) {
        Map<Method, Integer> mapMethods = mapCreate();
        int queueNumberMethod = mapMethods.get(method);
        mapMethods.forEach((key, value) -> {
            if (value <= queueNumberMethod) {
                try {
                    System.out.println(key.invoke(this));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Test
    public void printMap() {
        System.out.println(mapCreate());
    }

    @Test
    public void test() throws NoSuchMethodException {
        usedMapCreated(this.getClass().getDeclaredMethod("printSecondMessage"));
        usedMapCreated(this.getClass().getDeclaredMethod("printThirdMessage"));
        usedMapCreated(this.getClass().getDeclaredMethod("printFirstMessage"));
    }
}
