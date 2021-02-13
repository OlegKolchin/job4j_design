package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int index = 0;

    public T pop() {
        int count = 0;
        T value;
        while (true) {
           out.push(in.pop());
           index--;
           count++;
           if (index == 0) {
               value = out.pop();
               count--;
               while (count != 0) {
                   in.push(out.pop());
                   index++;
                   count--;
               }
               break;
           }
        }
        return value;
    }

    public void push(T value) {
        in.push(value);
        index++;
    }
}