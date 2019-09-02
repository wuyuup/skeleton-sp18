package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer x = new ArrayRingBuffer<String>(4);
        assertEquals(x.isEmpty(), true);
        x.enqueue("hello"); // 33.1 null null  null
        assertEquals(x.peek(), "hello");
        x.enqueue("zaijian"); // 33.1 44.8 null  null
        assertEquals(x.isFull(), false);
        x.enqueue("886"); // 33.1 44.8 62.3  null
        assertEquals(x.isEmpty(), false);
        x.enqueue("gudebai"); // 33.1 44.8 62.3 -3.4
        assertEquals(x.isFull(), true);
        assertEquals(x.dequeue(), "hello");     // 44.8 62.3 -3.4  null (returns 33.1)
        assertEquals(x.isFull(), false);
        assertEquals(x.isEmpty(), false);

        for (Object s : x) {
            System.out.println(s);
        }

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
