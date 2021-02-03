package ru.job4j.collection;



import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomLinkedList<E> implements Iterable<E>{

    private int point = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;


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

    private void checkIndex(int index) {
        Objects.checkIndex(index, point);
    }

    public E get(int index) {
        checkIndex(index);
        int count = 0;
        Node<E> node = first;
        while (count != index) {
            node = node.next;
            count++;
        }
        return node.item;
    }

    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
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
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
