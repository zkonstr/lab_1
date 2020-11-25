package bsu.rfe.java.group6.lab1.Zhibul.var7;

import java.util.Objects;

public class IceCream extends Food {
    @Override
    public int calculateCalories() {
        return switch (this.syrup) {
            case КАРАМЕЛЬНОЕ -> 350;
            case ШОКОЛАДНОЕ -> 400;
            case ВАНИЛЬНОЕ -> 300;
        };
    }

    public enum SyrupType {КАРАМЕЛЬНОЕ, ШОКОЛАДНОЕ, ВАНИЛЬНОЕ}

    private final SyrupType syrup;

    public IceCream(SyrupType syrup) {
        super("Мороженое");
        this.syrup = syrup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IceCream iceCream = (IceCream) o;
        return syrup == iceCream.syrup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(syrup);
    }

    @Override
    public String toString() {
        return super.toString() + " " + syrup.toString().toLowerCase();
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    @Override
    public void consume() {
        System.out.println(this + " съедено");
    }
}
