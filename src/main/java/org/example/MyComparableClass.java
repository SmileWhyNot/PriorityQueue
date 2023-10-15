package org.example;

public class MyComparableClass implements Comparable<MyComparableClass> {
    private int value;

    public MyComparableClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(MyComparableClass other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return "MyComparableClass{" +
                "value=" + value +
                '}';
    }
}
