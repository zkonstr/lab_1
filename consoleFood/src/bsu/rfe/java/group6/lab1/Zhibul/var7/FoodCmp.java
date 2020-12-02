package bsu.rfe.java.group6.lab1.Zhibul.var7;

import java.util.Comparator;

public class FoodCmp implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return ((Food)o2).toString().length() - ((Food)o1).toString().length();
    }
}
