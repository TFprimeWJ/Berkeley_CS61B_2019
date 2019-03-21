package project1A;

public class LinkedListDeque<T> {
    private int size;
    private TNode sentinel;

    /** TNode class */
    private class TNode {
        public T item;
        public TNode prev;
        public TNode next;

        public TNode(T i, TNode p, TNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /** Create an empty LinkedListDeque. */
    public LinkedListDeque() {
       sentinel = new TNode(null, null, null);
       sentinel.prev = sentinel;
       sentinel.next = sentinel;
       size = 0;
    }

    /** Return true if the list is empty, false if not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Return the size of the deque. */
    public int size() { return size; }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T x) {
        TNode temp = new TNode(x, sentinel, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T x) {
        TNode temp = new TNode(x, sentinel.prev, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size += 1;
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, return null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T firstItem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return firstItem;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, return null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T lastItem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return lastItem;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        TNode temp = sentinel;
        while(index-- > 0) {
            temp = temp.next;
        }
        return temp.item;
    }


    public void printDeque() {
        TNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item);
            System.out.print(' ');
            p = p.next;
        }
        System.out.println('\n');
    }

//    public static void main(String[] args) {
//        // Create a new L
//        LinkedListDeque<Integer> L = new LinkedListDeque<>();
//        // Check if it's empty
//        System.out.println(L.isEmpty());
//        // Add 5 to the first
//        L.addFirst(5);
//        L.printDeque();
//        // add 10 to the back
//        L.addLast(10);
//        L.printDeque();
//    }

}
