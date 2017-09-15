package com.shubham.java2blog;

import com.shubham.java2blog.service.CreateNumber;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : Shubham Aggarwal
 * @since : 15/09/17
 */
public class TestNgTest {

    private CreateNumber createNumber = null;

    @BeforeClass
    public void init() {
        createNumber = Mockito.mock(CreateNumber.class);
    }

    @Test
    public void testWith_TestNG() {

        int expected = 100;
        Mockito.when(createNumber.getThreeDigitNumber()).thenReturn(expected);

        int actual = createNumber.getThreeDigitNumber();
        Assert.assertEquals(actual, expected);
    }
}
