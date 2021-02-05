package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int index = 0;

    public T pop() {
        int count = 0;
        while (count < index) {
            out.push(in.pop());
            count++;
        }
        T value = out.pop();
        index--;
        count = 0;
        while (count < index) {
            in.push(out.pop());
            count++;
        }
        return value;
    }

    public void push(T value) {
        in.push(value);
        index++;
    }
}