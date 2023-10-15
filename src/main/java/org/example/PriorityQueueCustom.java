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

        while (curInd < curAddIndex-1) {
            int smallestIndex = getSmallestIndex(curInd);

            if (smallestIndex != curInd) {
                swap(curInd, smallestIndex);
                curInd = smallestIndex;
            } else {
                break;
            }
        }
    }

    private int getSmallestIndex(int curInd) {
        int leftChildIndex = 2 * curInd + 1;
        int rightChildIndex = 2 * curInd + 2;
        int smallestIndex = curInd;

        if (leftChildIndex < (curAddIndex - 1) && comparator.compare(elements[leftChildIndex], elements[smallestIndex]) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < (curAddIndex - 1) && comparator.compare(elements[rightChildIndex], elements[smallestIndex]) < 0) {
            smallestIndex = rightChildIndex;
        }
        return smallestIndex;
    }

    private void siftUp() {
        int lastElemIndex = curAddIndex - 1;
        while (lastElemIndex > 0) {
            int parentIndex = lastElemIndex / 2;
            T valToCompare = elements[parentIndex];
            if (comparator.compare( elements[lastElemIndex], valToCompare) < 0) {
                swap(lastElemIndex, parentIndex);
                lastElemIndex = parentIndex;
            } else
                break;
        }
    }

    private void swap(int curInd, int indToPaste) {
        T temp = elements[indToPaste];
        elements[indToPaste] = elements[curInd];
        elements[curInd] = temp;
    }

}
