package ru.job4j.collection;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedListTest {

    @Test
    public void whenGet() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        assertThat(list.get(0), is("first"));
        assertThat(list.get(1), is("second"));
        assertThat(list.get(2), is("third"));
    }

    @Test
    public void Iterator() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
        Iterator<String> iterator = list.iterator();
        assertThat(iterator.next(), is("First"));
        assertThat(iterator.next(), is("Second"));
        assertThat(iterator.next(), is("Third"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenError () {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("First");
        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.next();
    }

}