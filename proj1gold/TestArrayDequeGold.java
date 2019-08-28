/** This class tests studentArrayDeque and ArrayDequeSolution.
 * @author zyf.
 */

import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {

    @Test
    public void testStudentSolution() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<Integer>();

        String message = "";

        for (int i = 0; i < 10; ++i) {
            double coin = StdRandom.uniform();
            if (coin > 0.5) {
                sad.addFirst(i);
                ads.addFirst(i);
                message += ("addFirst(" + Integer.toString(i) + ")\n");
            } else {
                sad.addLast(i);
                ads.addLast(i);
                message += ("addLast(" + Integer.toString(i) + ")\n");
            }

        }

        for (int i = 0; i < 8; ++i) {
            double coin = StdRandom.uniform();
            if (coin > 0.5) {
                message += ("removeFirst()\n");
                assertEquals(message, ads.removeFirst(), sad.removeFirst());
            } else {
                message += ("removeLast()\n");
                assertEquals(message, ads.removeLast(), sad.removeLast());
            }
        }


    }
}
