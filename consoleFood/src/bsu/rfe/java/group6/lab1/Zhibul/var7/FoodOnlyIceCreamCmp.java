package bsu.rfe.java.group6.lab1.Zhibul.var7;

import java.util.Comparator;

public class FoodOnlyIceCreamCmp implements Comparator<Food> {

    @Override
    public int compare(Food o1, Food o2) {
        if (o1 == null){
            return 1;
        }
        if (o1.getClass().equals(IceCream.class)) {
            if (o2.getClass().equals(IceCream.class)) {
                return new IceCreamCmp().compare((IceCream) o1, (IceCream) o2);
            }
            return 1;
        }
        return -1;
    }
}
