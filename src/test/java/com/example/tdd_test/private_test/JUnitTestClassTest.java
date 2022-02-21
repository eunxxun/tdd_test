package com.example.tdd_test.private_test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.lang.reflect.Method;

import static org.hamcrest.Matchers.is;

//private 메소드 테스트
class JUnitTestClassTest {

    @Test
    void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        JUnitTestClass jUnitTestClass = new JUnitTestClass();
        Method method = jUnitTestClass.getClass().getDeclaredMethod("add", int.class, int.class);
        method.setAccessible(true);
        int ret = (int) method.invoke(jUnitTestClass, 1, 2);
        assertThat(ret, is(equalTo(3)));
    }
}