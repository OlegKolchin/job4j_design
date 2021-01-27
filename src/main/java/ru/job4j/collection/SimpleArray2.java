package ru.job4j.collection;

import java.util.*;

public class SimpleArray2<T> implements Iterable<T> {

    private T[] array;
    private int point = 0;
    private int modCount = 0;

    public SimpleArray2() {
        this.array = (T[]) new Object[0];
    }


    public void add(T model) {
        array = Arrays.copyOf(array, array.length + 1);
        array[point++] = model;
        modCount++;
    }

    private void checkIndex(int index) {
        Objects.checkIndex(index, point);
    }

    public void set(int index, T model) {
        checkIndex(index);
        array[index] = model;
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, array.length - (index + 1));
        array[array.length - 1] = null;
        point--;
        modCount++;
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int iter = 0;
            int expectedModcount = modCount;

            @Override
            public boolean hasNext() {
                return iter < point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModcount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return array[iter++];
            }
        };
    }
}
