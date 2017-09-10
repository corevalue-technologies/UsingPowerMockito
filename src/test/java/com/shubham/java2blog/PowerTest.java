package com.shubham.java2blog;

import com.shubham.java2blog.model.ClassWithFinalMethods;
import com.shubham.java2blog.model.ClassWithPrivateMethods;
import com.shubham.java2blog.model.ClassWithStaticMethod;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author : Shubham Aggarwal
 * @since : 10/09/17
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.shubham.java2blog.*")
public class PowerTest {

    @Test
    public void testClassWithFinalMethods_printMessage_finalMethod() throws Exception {

        String message = "Hello PowerMockito";

        ClassWithFinalMethods mockObject = PowerMockito.mock(ClassWithFinalMethods.class);
        PowerMockito.whenNew(ClassWithFinalMethods.class).withNoArguments().thenReturn(mockObject);

        ClassWithFinalMethods object = new ClassWithFinalMethods();
        PowerMockito.verifyNew(ClassWithFinalMethods.class).withNoArguments();

        PowerMockito.when(object.printMessage(message)).thenReturn(message);
        String helloPowerMockito = object.printMessage(message);
        Mockito.verify(object).printMessage(message);
        Assert.assertEquals(message, helloPowerMockito);
    }

    @Test
    public void testClassWithStaticMethod_printMessage_staticMethod() {

        String message = "Hello PowerMockito";
        String expectation = "Expectation";

        PowerMockito.mockStatic(ClassWithStaticMethod.class);
        PowerMockito.when(ClassWithStaticMethod.printMessage(message)).thenReturn(expectation);

        String actual = ClassWithStaticMethod.printMessage(message);
        Assert.assertEquals(expectation, actual);
    }

    @Test
    public void testClassWithPrivateMethods_printMessage_privateMethod() throws Exception {

        String message = "Hello PowerMockito";
        String expectation = "Expectation";

        ClassWithPrivateMethods mock = PowerMockito.spy(new ClassWithPrivateMethods());
        PowerMockito.doReturn(expectation).when(mock, "printMessage", message);

        String actual = mock.privateCall(message);
        Assert.assertEquals(expectation, actual);
    }
}
