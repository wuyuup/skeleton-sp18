package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        fillCount = 0;
        first = 0;
        last = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        fillCount += 1;
        rb[last] = x;
        last = (last + 1) % capacity;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T res = rb[first];
        //rb[first] = null;
        first = (first + 1) % capacity;
        fillCount -= 1;
        return res;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return rb[first];
    }


    /** iterator method.
     *
     * @return an iterator
     */
    public Iterator<T> iterator() {
        return new QueueIteratorC();
    }

    /** QueueIterator class. */
    private class QueueIteratorC implements Iterator<T> {
        /** position. */
        private int pos;

        /** init. */
        public QueueIteratorC() {
            pos = first;
        }

        /** has next?
         *
         * @return bool
         */
        public boolean hasNext() {
            return pos != last;
        }

        /** what is next?
         *
         * @return next item
         */
        public T next() {
            T nextItem = (T) rb[pos];
            pos = (pos + 1) % rb.length;
            return nextItem;
        }
    }

}
