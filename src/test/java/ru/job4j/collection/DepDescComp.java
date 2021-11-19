package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] a = o1.split("/");
        String[] b = o2.split("/");
        int res = b[0].compareTo(a[0]);
        if (res == 0) {
            return o1.compareTo(o2);
        } else {
            return res;
        }
    }
}