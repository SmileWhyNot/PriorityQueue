package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class PriorityQueueCustom<T> {
    private static final int INITIAL_ARRAY_LENGTH = 8;
    private int curAddIndex = 0;
    private T[] elements;
    private final Comparator<? super T> comparator;

    public PriorityQueueCustom(Class<T> clazz) {
        this(clazz, null);
    }

    public PriorityQueueCustom(Class<T> clazz, Comparator<? super T> comparator) {
        if (comparator == null && !Comparable.class.isAssignableFrom(clazz)) {
            throw new ClassCastException("Class must be Comparable or constructor needs comparator");
        }
        else if (comparator == null) {
            this.comparator = (o1, o2) -> ((Comparable<? super T>) o1).compareTo(o2);
        } else {
            this.comparator = comparator;
        }

        elements = (T[]) Array.newInstance(clazz, INITIAL_ARRAY_LENGTH);
    }

    public T peek() {
        return elements[0];
    }

    public void add(T value) {
        if (curAddIndex == 0) {
            elements[curAddIndex++] = value;
            return;
        } else if (curAddIndex >= elements.length - 1)  {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[curAddIndex++] = value;
        siftUp();
    }

    public T poll() {
        T elemToReturn = elements[0];
        siftDown();
        curAddIndex--;

        return elemToReturn;
    }

    private void siftDown() {
        elements[0] = elements[curAddIndex - 1];
        elements[curAddIndex - 1] = null;

        int curInd = 0;

        while (elements[2 * curInd + 1] != null && elements[2 * curInd + 2] != null) {
            int indToPaste = (comparator.compare(elements[2 * curInd + 1], elements[2 * curInd + 2]) < 0) ? (2 * curInd + 1) : (2 * curInd + 2);
            swap(elements, curInd, indToPaste);
            curInd = indToPaste;
        }
        if(elements[2 * curInd + 1] != null && comparator.compare(elements[2 * curInd + 1], elements[curInd]) < 0) {
            swap(elements, curInd, 2 * curInd + 1);
        } else if (elements[2 * curInd + 2] != null  && comparator.compare(elements[2 * curInd + 2], elements[curInd]) < 0) {
            swap(elements, curInd, 2 * curInd + 2);
        }
    }

    private void siftUp() {
        int lastElemIndex = curAddIndex - 1;
        while (lastElemIndex > 0) {
            int parentIndex = lastElemIndex / 2;
            T valToCompare = elements[parentIndex];
            if (comparator.compare( elements[lastElemIndex], valToCompare) < 0) {
                swap(elements, lastElemIndex, parentIndex);
                lastElemIndex = parentIndex;
            } else
                break;
        }
    }

    private void swap(T[] mass, int curInd, int indToPaste) {
        T temp = mass[indToPaste];
        mass[indToPaste] = mass[curInd];
        mass[curInd] = temp;
    }

}
