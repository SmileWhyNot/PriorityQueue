package org.example;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

// Вариант 1: Создать объект PriorityQueueCustom и передать класс, реализующий Comparable
//        PriorityQueueCustom<MyComparableClass> queue1 = new PriorityQueueCustom<>(MyComparableClass.class);
//        queue1.add(new MyComparableClass(6));
//        queue1.add(new MyComparableClass(17));
//        queue1.add(new MyComparableClass(10));
//        queue1.add(new MyComparableClass(50));
//        queue1.add(new MyComparableClass(39));
//        queue1.add(new MyComparableClass(21));
//        queue1.add(new MyComparableClass(40));
//        queue1.add(new MyComparableClass(60));
//        queue1.add(new MyComparableClass(75));
//
//        System.out.println("Queue 1:");
//        System.out.println(queue1.poll());
//        System.out.println(queue1.poll());
//        System.out.println(queue1.poll());
//        System.out.println(queue1.poll());
//        System.out.println(queue1.poll());
//        System.out.println(queue1.poll());
//        System.out.println(queue1.poll());
//        System.out.println(queue1.poll());
//        System.out.println(queue1.poll());



// Вариант 2: Создать объект PriorityQueueCustom и передать класс, НЕ реализующий Comparable, НО передать Comparator
//        Comparator<MyNonComparableClass> customComparator = Comparator.comparing(MyNonComparableClass::getValue);
//        PriorityQueueCustom<MyNonComparableClass> queue2 = new PriorityQueueCustom<>(MyNonComparableClass.class, customComparator);
//        queue2.add(new MyNonComparableClass(6));
//        queue2.add(new MyNonComparableClass(17));
//        queue2.add(new MyNonComparableClass(10));
//        queue2.add(new MyNonComparableClass(50));
//        queue2.add(new MyNonComparableClass(39));
//        queue2.add(new MyNonComparableClass(21));
//        queue2.add(new MyNonComparableClass(40));
//        queue2.add(new MyNonComparableClass(60));
//        queue2.add(new MyNonComparableClass(75));
//
//        System.out.println("Queue 2:");
//        System.out.println(queue2.poll());
//        System.out.println(queue2.poll());
//        System.out.println(queue2.poll());
//        System.out.println(queue2.poll());
//        System.out.println(queue2.poll());
//        System.out.println(queue2.poll());
//        System.out.println(queue2.poll());
//        System.out.println(queue2.poll());
//        System.out.println(queue2.poll());

        // Вариант 3: Создать объект PriorityQueueCustom и передать собственно созданный класс, который не является Comparable, чтобы получить ошибку

//        PriorityQueueCustom<MyNonComparableClass> queue3 = new PriorityQueueCustom<>(MyNonComparableClass.class);
//        queue3.add(new MyNonComparableClass(8));
//        queue3.add(new MyNonComparableClass(4));
//        queue3.add(new MyNonComparableClass(2));
//
//        System.out.println("Queue 2:");
//        queue3.poll();
//        queue3.poll();
//        queue3.poll();


    }
}