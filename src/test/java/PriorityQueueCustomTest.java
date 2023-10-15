import org.example.MyComparableClass;
import org.example.MyNonComparableClass;
import org.example.PriorityQueueCustom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriorityQueueCustomTest {
    private PriorityQueueCustom<MyComparableClass> comparableQueue;
    private PriorityQueueCustom<MyNonComparableClass> nonComparableQueue;
    private PriorityQueueCustom<MyNonComparableClass> reversedNonComparableQueue;

    @BeforeEach
    public void setUp() {
        comparableQueue = new PriorityQueueCustom<>(MyComparableClass.class);
        nonComparableQueue = new PriorityQueueCustom<>(MyNonComparableClass.class, Comparator.comparing(MyNonComparableClass::getValue));
        Comparator<MyNonComparableClass> reversedComparator = (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue());
        reversedNonComparableQueue = new PriorityQueueCustom<>(MyNonComparableClass.class, reversedComparator);
    }

    @Test
    public void testComparableQueue() {
        comparableQueue.add(new MyComparableClass(6));
        comparableQueue.add(new MyComparableClass(17));
        comparableQueue.add(new MyComparableClass(10));
        comparableQueue.add(new MyComparableClass(50));

        assertEquals(4, comparableQueue.getSize());
        assertEquals(6, comparableQueue.peek().getValue());
        assertEquals(6, comparableQueue.poll().getValue());
        assertEquals(3, comparableQueue.getSize());
        assertEquals(10, comparableQueue.peek().getValue());

        comparableQueue.add(new MyComparableClass(39));
        comparableQueue.add(new MyComparableClass(21));
        comparableQueue.add(new MyComparableClass(40));
        comparableQueue.add(new MyComparableClass(60));
        comparableQueue.add(new MyComparableClass(75));

        assertEquals(8, comparableQueue.getSize());
        assertEquals(10, comparableQueue.peek().getValue());
        assertEquals(10, comparableQueue.poll().getValue());
        assertEquals(7, comparableQueue.getSize());

        int prevValue = -1;
        while (comparableQueue.getSize() > 0) {
            int currentValue = comparableQueue.poll().getValue();
            assertTrue(currentValue >= prevValue);
            prevValue = currentValue;
        }
    }

    @Test
    public void testNonComparableQueue() {
        nonComparableQueue.add(new MyNonComparableClass(6));
        nonComparableQueue.add(new MyNonComparableClass(17));
        nonComparableQueue.add(new MyNonComparableClass(10));
        nonComparableQueue.add(new MyNonComparableClass(50));

        assertEquals(4, nonComparableQueue.getSize());
        assertEquals(6, nonComparableQueue.peek().getValue());
        assertEquals(6, nonComparableQueue.poll().getValue());
        assertEquals(3, nonComparableQueue.getSize());
        assertEquals(10, nonComparableQueue.peek().getValue());

        nonComparableQueue.add(new MyNonComparableClass(39));
        nonComparableQueue.add(new MyNonComparableClass(21));
        nonComparableQueue.add(new MyNonComparableClass(40));
        nonComparableQueue.add(new MyNonComparableClass(60));
        nonComparableQueue.add(new MyNonComparableClass(75));

        assertEquals(8, nonComparableQueue.getSize());
        assertEquals(10, nonComparableQueue.peek().getValue());
        assertEquals(10, nonComparableQueue.poll().getValue());
        assertEquals(7, nonComparableQueue.getSize());

        int prevValue = -1;
        while (nonComparableQueue.getSize() > 0) {
            int currentValue = nonComparableQueue.poll().getValue();
            assertTrue(currentValue >= prevValue);
            prevValue = currentValue;
        }
    }

    @Test
    public void testNonComparableQueueWithReversedComparator() {
        reversedNonComparableQueue.add(new MyNonComparableClass(6));
        reversedNonComparableQueue.add(new MyNonComparableClass(17));
        reversedNonComparableQueue.add(new MyNonComparableClass(10));
        reversedNonComparableQueue.add(new MyNonComparableClass(50));

        assertEquals(4, reversedNonComparableQueue.getSize());
        assertEquals(50, reversedNonComparableQueue.peek().getValue());
        assertEquals(50, reversedNonComparableQueue.poll().getValue());
        assertEquals(3, reversedNonComparableQueue.getSize());
        assertEquals(17, reversedNonComparableQueue.peek().getValue());

        reversedNonComparableQueue.add(new MyNonComparableClass(39));
        reversedNonComparableQueue.add(new MyNonComparableClass(21));
        reversedNonComparableQueue.add(new MyNonComparableClass(40));
        reversedNonComparableQueue.add(new MyNonComparableClass(60));
        reversedNonComparableQueue.add(new MyNonComparableClass(75));

        assertEquals(8, reversedNonComparableQueue.getSize());
        assertEquals(75, reversedNonComparableQueue.peek().getValue());
        assertEquals(75, reversedNonComparableQueue.poll().getValue());
        assertEquals(7, reversedNonComparableQueue.getSize());

        int prevValue = Integer.MAX_VALUE;
        while (reversedNonComparableQueue.getSize() > 0) {
            int currentValue = reversedNonComparableQueue.poll().getValue();
            assertTrue(currentValue <= prevValue);
            prevValue = currentValue;
        }
    }

    @Test
    public void testNonComparableQueueWithoutComparator() {
        try {
            PriorityQueueCustom<MyNonComparableClass> queue3 = new PriorityQueueCustom<>(MyNonComparableClass.class);
            Assertions.fail("Expected ClassCastException");
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}
