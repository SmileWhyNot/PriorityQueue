# Custom Priority Queue

This is a custom implementation of a PriorityQueue, created as part of the Clevertec course assignment. The project provides a Java priority queue data structure that offers features such as dynamic resizing, customizable comparators, and support for both comparable and non-comparable elements.

## Assignment Description

The assignment required the implementation of a custom PriorityQueue with the following specifications:

- Interface with the methods `add`, `peek`, and `poll`.
- Support for storing elements of any type that implement the `Comparable` interface.
- Usage of the "Min Binary Heap" data structure, ensuring that the minimum element is at the top.
- Elements are stored in a dynamically resizing Java array.
- Default initial array size of 8.
- Implementation of `siftUp` and `siftDown` procedures for maintaining the heap structure.
- The ability to provide a custom `Comparator` in the constructor, allowing non-comparable elements to be used.

## Usage

To use the Custom Priority Queue:

1. Create an instance of `PriorityQueueCustom` by specifying the element type and, optionally, a custom comparator:

    ```java
    // Example with comparable elements
    PriorityQueueCustom<MyComparableClass> queue = new PriorityQueueCustom<>(MyComparableClass.class);

    // Example with non-comparable elements and a custom comparator
    PriorityQueueCustom<MyNonComparableClass> queue = new PriorityQueueCustom<>(MyNonComparableClass.class, myComparator);
    ```

2. Add elements, retrieve the highest-priority element, or remove and retrieve it:

    ```java
    queue.add(element);
    MyComparableClass highestPriority = queue.peek();
    MyComparableClass removedElement = queue.poll();
    ```

3. Check the size of the queue:

    ```java
    int size = queue.getSize();
    ```

## Support for Non-Comparable Elements

The project offers the flexibility to handle non-comparable elements by allowing you to provide a custom `Comparator`. If no `Comparator` is provided and the elements do not implement `Comparable`, an error will be raised.

For example:

```java
PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
q.add(10);
q.add(20);
System.out.println(q.peek()); // Should output 20
```

## Tests

The project includes unit tests in the `PriorityQueueCustomTest` class to verify the functionality of the Custom Priority Queue for both comparable and non-comparable elements.

## Note

Ensure that you handle the potential `ClassCastException` when attempting to create a priority queue for non-comparable elements without specifying a custom comparator.

This Custom Priority Queue is a versatile data structure that can efficiently manage elements based on their priority, making it a valuable addition to your Java projects.