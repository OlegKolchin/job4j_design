package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSetTest {

    @Test
    public void whenAdd() {
        SimpleSet<String> set = new SimpleSet<>();
        assertThat(set.add("f"), is(true));
    }

    @Test
    public void whenAddFew() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("First");
        set.add("Second");
        Iterator<String> it = set.iterator();
        assertThat(it.next(), is("First"));
        assertThat(it.next(), is("Second"));
    }

    @Test
    public void whenAddDublicate() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("First");
        set.add("First");
        set.add("Second");
        Iterator<String> it = set.iterator();
        assertThat(it.next(), is("First"));
        assertThat(it.next(), is("Second"));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNextNull() {
        SimpleSet<String> set = new SimpleSet<>();
        Iterator<String> it = set.iterator();
        it.next();
    }
}