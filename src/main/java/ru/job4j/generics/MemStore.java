package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        for (T t : mem) {
            if (t.getId().equals(id)) {
                t = model;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (T t : mem) {
            if (t.getId().equals(id)) {
                mem.remove(t);
                return true;
            }
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (T t : mem) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }
}