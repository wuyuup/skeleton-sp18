public class LinkedListDeque<T> implements Deque<T>{

    private int size;
    private ListNode sentinel = new ListNode(63, null, null);

    private static class ListNode<T> {
        private T item;
        private ListNode next;
        private ListNode prev;
        public ListNode(T x, ListNode n, ListNode p) {
            item = x;
            next = n;
            prev = p;
        }
    }

    /** create an empty linkedlistdeque */
    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new ListNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new ListNode(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
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
        ListNode ptr = sentinel.next;
        for (int i = 0; i < size; ++i) {
            System.out.print(ptr.item);
            System.out.print(" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return res;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = (T) sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return res;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        ListNode ptr = sentinel.next;
        for (int i = 0; i < index; ++i) {
            ptr = ptr.next;
        }
        return (T) ptr.item;
    }


    private T getRecHelper(int index, ListNode curr) {
        if (index == 0) {
            return (T) curr.item;
        }
        return (T) getRecHelper(index - 1, curr.next);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return (T) getRecHelper(index, sentinel.next);
    }
}
