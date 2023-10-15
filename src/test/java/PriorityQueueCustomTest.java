import org.example.MyComparableClass;
import org.example.MyNonComparableClass;
import org.example.PriorityQueueCustom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriorityQueueCustomTest {
    private PriorityQueueCustom<MyComparableClass> comparableQueue;
    private PriorityQueueCustom<MyNonComparableClass> nonComparableQueue;

    @BeforeEach
    public void setUp() {
        comparableQueue = new PriorityQueueCustom<>(MyComparableClass.class);
        nonComparableQueue = new PriorityQueueCustom<>(MyNonComparableClass.class, Comparator.comparing(MyNonComparableClass::getValue));
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
}
