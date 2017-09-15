package com.shubham.java2blog;

import com.shubham.java2blog.service.MathService;
import com.shubham.java2blog.service.impl.MathServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author : Shubham Aggarwal
 * @since : 15/09/17
 */
@RunWith(MockitoJUnitRunner.class)
public class JUnitTest {

    @Mock
    MathService mathService;

    @InjectMocks
    MathServiceImpl mathServiceImpl = new MathServiceImpl();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_doubleLong_Pass() {
        long expected = 20;
        Mockito.when(mathService.doubleLong(Mockito.anyLong())).thenReturn(expected);

        long actual = mathService.doubleLong(Mockito.anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_doubleLong_Inject() {
        long expected = 20;
        long actual = mathServiceImpl.doubleLong(10);

        Assert.assertEquals(expected, actual);
    }

}
