package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when000to200then2() {
        double expected = 2;
        int x1 = 0;
        int y1 = 0;
        int z1 = 0;
        int x2 = 2;
        int y2 = 0;
        int z2 = 0;
        Point a = new Point(x1, y1, z1);
        Point b = new Point(x2, y2, z2);
        double dist = a.distance3d(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when30to20then1() {
        double expected = 1;
        int x1 = 3;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }
}