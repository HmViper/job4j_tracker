package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax123Then3() {
        int one = 1;
        int two = 2;
        int three = 3;
        int result = Max.max(one, two, three);
        int expected = 3;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax1234Then4() {
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;
        int result = Max.max(one, two, three, four);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }

}