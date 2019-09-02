package synthesizer;

/** abstract class for BoundedQueue.
 * @author zyf
 * @param <T> type parameter
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /** number of fill-outs. */
    protected int fillCount;

    /** capacity. */
    protected int capacity;

    /** capacity of the queue.
     *
     * @return capacity
     */
    public int capacity() {
        return capacity;
    }

    /** number of fill-outs in the queue.
     *
     * @return number of fills
     */
    public int fillCount() {
        return fillCount;
    }
    // public boolean isEmpty()
    // public boolean isFull()

    /** return first item.
     *
     * @return first item
     */
    public abstract T peek();

    /** delete and return first item.
     *
     * @return first item
     */
    public abstract T dequeue();

    /** add.
     *
     * @param x item to be added
     */
    public abstract void enqueue(T x);

}
