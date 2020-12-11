package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIt(int[] data) {
        this.data = data;
    }

    private void skipUneven() {
        while (point < data.length && data[point] % 2 != 0) {
            point++;
        }
    }

    @Override
    public boolean hasNext() {
        this.skipUneven();
        return point < data.length;
    }

    @Override
    public Integer next() {
        this.skipUneven();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

}
