package ru.job4j.collection;

import java.util.*;

public class SimpleSet<T>{
    private SimpleArray2<T> array = new SimpleArray2<>();

    public boolean contains (T model) {
        for (T t : array.getArray()) {
            if (Objects.equals(t, model)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(T model) {
        if (! contains(model)) {
            array.add(model);
            return true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        return array.iterator();
    }

}

