package synthesizer;
import java.util.Iterator;

/** BoundedQueue interface.
 *
 * @author zyf
 * @param <T> type param
 */
public interface BoundedQueue<T> extends Iterable<T> {
    /** Return size of a buffer.
     *
     * @return size of a buffer
     */
    int capacity();

    /** Return an iterator.
     *
     * @return an iterator.
     */
    Iterator<T> iterator();

    /** return number of items currently in the buffer.
     *
     * @return number of items currently in the buffer
     */
    int fillCount();

    /** add item x to the end.
     *
     * @param x item to be added
     */
    void enqueue(T x);

    /**
     * delete and return item from the front.
     * @return the item that being deleted
     */
    T dequeue();

    /** return (but do not delete) item from the front.
     *
     * @return item from the front
     */
    T peek();

    /** check if the deque is empty.
     *
     * @return true if it is empty
     */
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    /** check if it is full.
     *
     * @return true if full
     */
    default boolean isFull() {
        return fillCount() == capacity();
    }
}
