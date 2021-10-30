package ru.job4j.collection;

import java.nio.charset.CharsetEncoder;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lengthLeft = left.length();
        int lengthRight = right.length();
        int minLength = Math.min(lengthLeft, lengthRight);
        for (int i = 0; i < minLength; i++) {
            int comp = Character.compare(left.charAt(i), right.charAt(i));
            if (comp != 0) {
                return comp;
            }
        }
        return Integer.compare(lengthLeft, lengthRight);
    }
}