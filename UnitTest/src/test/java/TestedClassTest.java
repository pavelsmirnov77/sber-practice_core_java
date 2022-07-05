import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;
import java.lang.reflect.Method;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestedClassTest {
    private static final double DELTA = 1e-15;
    TestedClass testedClass = new TestedClass();
    private static final double TESTED_AREA_CYLINDER = 94.2;
    private static final double TESTED_VOLUME_CYLINDER = 56.52;
    @Test
    public void getTestedAreaCylinder() {
        Assert.assertEquals(TESTED_AREA_CYLINDER, testedClass.areaCylinder(3,2), DELTA);
    }
    @Test
    public void getTestedVolumeCylinder() {
        Assert.assertEquals(TESTED_VOLUME_CYLINDER, testedClass.volumeCylinder(3,2), DELTA);
    }

    @Test
    public void getSpiedAreaCylinder() {
        TestedClass testedClass = Mockito.spy(TestedClass.class);
        testedClass.areaCylinder(3,2);
        testedClass.volumeCylinder(3,2);

        verify(testedClass, times(1)).perimeterCircle(3);
        verify(testedClass, times(1)).summation(3,2);
        verify(testedClass, times(1)).multiplication(18.84, 5);
        verify(testedClass, times(1)).multiplication(28.26, 2);
        verify(testedClass, times(1)).perimeterCircle(3);
    }

    @Test(expected = IllegalStateException.class)
    public void testedMethodTest() {
        TestedClass testedClass = mock(TestedClass.class);
        when(testedClass.areaCylinder(3,2)).thenThrow(new IllegalStateException());
        testedClass.areaCylinder(3,2);
        when(testedClass.volumeCylinder(3,2)).thenThrow(new IllegalStateException());
        testedClass.volumeCylinder(3,2);
    }

    @Test
    public void privateMethodTest() throws Exception {
        TestedClass testedClass = new TestedClass();
        Method privateMethod = TestedClass.class.getDeclaredMethod("getFigure", null);
        privateMethod.setAccessible(true);
        String returnValue = (String) privateMethod.invoke(testedClass, null);
        assertEquals("Cylinder", returnValue);
    }
}
