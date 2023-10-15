package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class PriorityQueueCustom<T> {
    private static final int INITIAL_ARRAY_LENGTH = 8;
    private int currentQueueSize = 0;
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

    public int getSize() {
        return currentQueueSize;
    }

    public T peek() {
        return elements[0];
    }

    public void add(T value) {
        if (currentQueueSize == 0) {
            elements[currentQueueSize++] = value;
            return;
        } else if (currentQueueSize >= elements.length - 1)  {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[currentQueueSize++] = value;
        siftUp();
    }

    public T poll() {
        T elemToReturn = elements[0];
        siftDown();
        currentQueueSize--;

        return elemToReturn;
    }

    private void siftDown() {
        elements[0] = elements[currentQueueSize - 1];
        elements[currentQueueSize - 1] = null;

        int addedElemIndex = 0;

        while (addedElemIndex < currentQueueSize - 1) {
            int smallestIndex = getSmallestIndex(addedElemIndex);

            if (smallestIndex != addedElemIndex) {
                swap(addedElemIndex, smallestIndex);
                addedElemIndex = smallestIndex;
            } else {
                break;
            }
        }
    }

    private int getSmallestIndex(int addedElemIndex) {
        int leftChildIndex = 2 * addedElemIndex + 1;
        int rightChildIndex = 2 * addedElemIndex + 2;
        int smallestIndex = addedElemIndex;

        if (leftChildIndex < (currentQueueSize - 1)
                && comparator.compare(elements[leftChildIndex], elements[smallestIndex]) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < (currentQueueSize - 1)
                && comparator.compare(elements[rightChildIndex], elements[smallestIndex]) < 0) {
            smallestIndex = rightChildIndex;
        }
        return smallestIndex;
    }

    private void siftUp() {
        int addedElemIndex = currentQueueSize - 1;
        while (addedElemIndex > 0) {
            int parentIndex = (addedElemIndex - 1) / 2;
            T parentToCompare = elements[parentIndex];
            if (comparator.compare( elements[addedElemIndex], parentToCompare) < 0) {
                swap(addedElemIndex, parentIndex);
                addedElemIndex = parentIndex;
            } else
                break;
        }
    }

    private void swap(int x, int y) {
        T temp = elements[y];
        elements[y] = elements[x];
        elements[x] = temp;
    }

}
