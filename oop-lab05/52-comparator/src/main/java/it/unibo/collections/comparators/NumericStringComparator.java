package it.unibo.collections.comparators;

import java.util.Comparator;

public final class NumericStringComparator implements Comparator<String> {

    @Override
    public int compare(final String s1, final String s2) {
        Double d1 = Double.parseDouble(s1);
        Double d2 = Double.parseDouble(s2);
        return d1.compareTo(d2);
    }
}