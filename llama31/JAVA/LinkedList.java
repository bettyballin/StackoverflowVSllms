import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private int size = 0;
    private int modCount = 0;

    private Node<E> first;
    private Node<E> last;

    public void add(E e) {
        add(size, e);
    }

    public void add(int index, E element) {
        if (index == size) {
            Node<E> newNode = new Node<>(last, element, null);
            if (last != null) {
                last.next = newNode;
            }
            last = newNode;
            if (first == null) {
                first = newNode;
            }
            size++;
            modCount++;
        } else {
            addBefore(node(index), element);
        }
    }

    public E remove(int index) {
        return remove(node(index));
    }

    public boolean add(E e) {
        add(size, e);
        return true;
    }

    public E remove(Node<E> x) {
        if (x.next != null) {
            x.next.prev = x.prev;
        }
        if (x.prev != null) {
            x.prev.next = x.next;
        }
        if (x == first) {
            first = x.next;
        }
        if (x == last) {
            last = x.prev;
        }
        E result = x.item;
        x.item = null;
        x.next = null;
        x.prev = null;
        size--;
        modCount++;
        return result;
    }

    private void addBefore(Node<E> node, E element) {
        Node<E> newNode = new Node<>(node.prev, element, node);
        if (node == first) {
            first = newNode;
        } else {
            node.prev.next = newNode;
        }
        node.prev = newNode;
        size++;
        modCount++;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        int n = c.size();
        if (n == 0)
            return false;
        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }
        for (E e : c) {
            Node<E> newNode = new Node<>(pred, e, succ);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            if (succ == null) {
                last = newNode;
            } else {
                succ.prev = newNode;
            }
            pred = newNode;
        }
        size += n;
        modCount++;
        return true;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    public Iterator<E> iterator() {
        return new ListItr(0);
    }

    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index, size);
        return new ListItr(index);
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex(int index, int size) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private class ListItr implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(int index) {
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public E next() {
            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {
            checkForComodification();
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null ? last : next.prev);
            nextIndex--;
            return lastReturned.item;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();
            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned, lastNext);
            if (next == lastReturned)
                next = lastNext;
            lastReturned = null;
            expectedModCount = modCount;
        }

        public void set(E e) {
            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.item = e;
        }

        public void add(E e) {
            checkForComodification();
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            expectedModCount = modCount;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }

        private void linkLast(E e) {
            Node<E> newNode = new Node<>(last, e, null);
            if (last != null) {
                last.next = newNode;
            }
            last = newNode;
            if (first == null) {
                first = newNode;
            }
            size++;
            modCount++;
        }

        private void linkBefore(E e, Node<E> succ) {
            Node<E> newNode = new Node<>(succ.prev, e, succ);
            if (succ == first) {
                first = newNode;
            } else {
                succ.prev.next = newNode;
            }
            succ.prev = newNode;
            size++;
            modCount++;
        }

        private void unlink(Node<E> x, Node<E> next) {
            if (x.next != null) {
                x.next.prev = x.prev;
            }
            if (x.prev != null) {
                x.prev.next = x.next;
            }
            if (x == first) {
                first = x.next;
            }
            if (x == last) {
                last = x.prev;
            }
            x.item = null;
            x.next = null;
            x.prev = null;
            size--;
            modCount++;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.size()); // prints 3
        System.out.println(list.get(1)); // prints B
    }
}