package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T pop() {
        T value;
        while (true) {
           out.push(in.pop());
           if (in.isEmpty()) {
               value = out.pop();
               while (!out.isEmpty()) {
                   in.push(out.pop());
               }
               break;
           }
        }
        return value;
    }

    public void push(T value) {
        in.push(value);
    }
}