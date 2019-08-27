public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private T[] items = (T[]) new Object[8];
    private int first; // position of first element is first
    private int last; // position of last element is last-1

    public ArrayDeque() {
        size = 0;
        first = 0;
        last = 0;
    }

    private void resize(int cap) {
        T[] tmpItems = (T[]) new Object[cap];
        if (first + size <= items.length) {
            System.arraycopy(items, first, tmpItems, 0, size);
        } else {
            System.arraycopy(items, first, tmpItems, 0, size - first);
            System.arraycopy(items, 0, tmpItems, size - first, last);
        }
        items = tmpItems;
        first = 0;
        last = size;
    }

    @Override
    public void addFirst(T item) {
        if (size >= items.length) {
            resize(size * 2);
        }

        // find the new position for first item
        first = Math.floorMod(first - 1, items.length);
        items[first] = item;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size >= items.length) {
            resize(size * 2);
        }

        // last is exactly the pos for new item
        items[last] = item;
        last = Math.floorMod(last + 1, items.length);
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int i = first;
        while (i != last) {
            System.out.print(items[i]);
            System.out.print(" ");
            // update counter
            i = (i + 1) % items.length;
        }
        // print empty line
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T res = items[first];
        items[first] = null;
        first = (first + 1) % items.length;
        size -= 1;

        // rescale if needed
        if (size + 2 <= items.length * 0.25) {
            resize(items.length / 2);
        }
        return res;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        // find pos for the last item
        last = Math.floorMod(last - 1, items.length);
        T res = items[last];
        items[last] = null;
        size -= 1;

        // rescale if needed
        if (size + 2 <= items.length * 0.25) {
            resize(items.length / 2);
        }
        return res;
    }

    @Override
    public T get(int index) {
        return items[(first + index) % items.length];
    }
}
