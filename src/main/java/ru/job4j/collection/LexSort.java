package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] splLeft = left.split(". ");
        String[] splRight = right.split(". ");
        int l = Integer.parseInt(splLeft[0]);
        int r = Integer.parseInt(splRight[0]);
        return Integer.compare(l, r);
    }
}