package ru.job4j.collection;

import java.util.*;

public class SimpleSet<T> implements Iterable<T>{
    private T[] array;
    private int point = 0;

    public SimpleSet() {
        this.array = (T[]) new Object[10];
    }

    public void extend() {
        array = Arrays.copyOf(array, array.length + (array.length / 2));
    }

    public boolean add(T model) {
        if (point == array.length - 1) extend();
        for (T t : array) {
            if (t != null && t.equals(model)) {
                return false;
            }
        }
        array[point++] = model;
        return true;
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

