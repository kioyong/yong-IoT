package com.yong.iot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Test
    public void mockTest() {
        Aclass aclass = new Aclass();
        Aclass spy = Mockito.spy(aclass);
        spy.methodA("aa");
        System.out.println("------- start mock test ------");
        doReturn(false).when(spy).methodB("aa");
        spy.methodA("aa");

    }


}
