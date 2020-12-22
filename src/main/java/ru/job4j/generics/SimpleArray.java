package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private final T[] array;
    private int point = 0;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public void add(T model) {
        array[point++] = model;
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
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int iter = 0;

            @Override
            public boolean hasNext() {
                return iter < point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[iter++];
            }
        };
    }
}
