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

}
