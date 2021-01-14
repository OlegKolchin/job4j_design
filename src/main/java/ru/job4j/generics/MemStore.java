package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    private int findIndex(String id) {
        Optional<T> t = mem.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
        return mem.indexOf(t);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndex(id);
        if (index != -1) {
            mem.set(index, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndex(id);
        if (index != -1) {
            mem.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int index = findIndex(id);
        return index != -1 ? mem.get(index) : null;
    }
}