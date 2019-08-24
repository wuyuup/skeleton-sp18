public class LinkedListDeque<T> {

    private int size;
    private listNode sentinel = new listNode(63, null, null);

    private class listNode<T> {
        public T item;
        public listNode next;
        public listNode prev;
        public listNode(T x, listNode n, listNode p){
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

    public LinkedListDeque(T item) {
        sentinel.next = new listNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.next = new listNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new listNode(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        if (this.size == 0){
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        listNode ptr = sentinel.next;
        for (int i = 0; i < size; ++i) {
            System.out.print(ptr.item);
            System.out.print(" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

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

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        listNode ptr = sentinel.next;
        for (int i = 0; i < index; ++i) {
            ptr = ptr.next;
        }
        return (T) ptr.item;
    }


    private T getRecHelper(int index, listNode curr) {
        if (index == 0) {
            return (T) curr.item;
        }
        return (T) getRecHelper(index-1, curr.next);
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return (T) getRecHelper(index, sentinel.next);
    }
}
