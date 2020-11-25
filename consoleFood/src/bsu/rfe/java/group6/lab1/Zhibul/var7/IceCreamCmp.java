package bsu.rfe.java.group6.lab1.Zhibul.var7;

import java.util.Comparator;

public class IceCreamCmp implements Comparator<IceCream> {

    @Override
    public int compare(IceCream o1, IceCream o2) {
        return o1.getSyrup().toString().length() - o2.getSyrup().toString().length();
    }
}
