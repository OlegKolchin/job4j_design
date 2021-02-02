package ru.job4j.collection;



import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList<E> implements Iterable<E>{

    private int index = 0;
    transient int point = 0;
    transient Node<E> first;
    transient Node<E> last;
    private int modCount = 0;


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        public int index;

        public int getIndex() {
            return index;
        }

        Node(Node<E> prev, E element, Node<E> next, int index) {
            this.item = element;
            this.next = next;
            this.prev = prev;
            this.index = index;
    }
    }

    private void checkIndex(int index) {
        Objects.checkIndex(index, point);
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> node = first;
        while (node.getIndex() != index) {
            node = node.next;
        }
        return node.item;
    }

    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null, index++);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        point++;
        modCount++;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> current = first;
            int iter = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return iter < point;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (current.next == null) {
                    iter++;
                    return current.item;
                }
                current = current.next;
                iter++;
                return current.prev.item;
            }
        };
    }
}
