package ru.job4j.generics;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
public class SimpleArrayTest {

    @Test
    public void addCheck() {

        SimpleArray<String> array = new SimpleArray(5);
        array.add("Vasya");
        array.add("Grisha");
        assertThat(array.get(0), is("Vasya"));
        assertThat(array.get(1), is("Grisha"));

    }

    @Test
    public void setCheck() {

        SimpleArray<String> array = new SimpleArray(2);
        array.add("first");
        array.add("second");
        array.set(1, "test");
        assertThat(array.get(1), is("test"));
    }

    @Test
    public void remove() {

        SimpleArray<String> array = new SimpleArray<>(4);
        array.add("Oleg");
        array.add("Petr");
        array.add("Masha");
        array.add("Grisha");
        array.remove(2);
        assertThat(array.get(2), is("Grisha"));

    }


    @Test (expected = IndexOutOfBoundsException.class)
    public void whenGetThrowException() {
        SimpleArray<String> array = new SimpleArray<>(2);
        array.add("Oleg");
        array.get(1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenSetThrowException() {
        SimpleArray<String> array = new SimpleArray<>(2);
        array.add("Oleg");
        array.set(1, "Vasiliy");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenRemoveThrowException() {
        SimpleArray<String> array = new SimpleArray<>(4);
        array.add("Oleg");
        array.add("Petr");
        array.add("Masha");
        array.remove(3);
    }

    @Test
    public void iteratorCheck() {
        SimpleArray<String> array = new SimpleArray<>(5);
        array.add("Oleg");
        array.add("Petr");
        array.add("Masha");
        array.add("Grisha");
        assertThat(array.iterator().next(), is("Oleg"));
        assertThat(array.iterator().next(), is("Petr"));
        assertThat(array.iterator().next(), is("Masha"));
        assertThat(array.iterator().next(), is("Grisha"));
        assertThat(array.iterator().next(), is(nullValue()));
    }

}