package org.example;

public class MyNonComparableClass {
    private int value;

    public MyNonComparableClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MyNonComparableClass{" +
                "value=" + value +
                '}';
    }
}
