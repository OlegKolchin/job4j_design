package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 0, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddAfter2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.addAfter(input, 1, 0);
        assertThat(Arrays.asList(1, 2, 0, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfter3() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.addAfter(input, 3, 0);
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        Predicate<Integer> predicate = n -> n == 2;
        ListUtils.removeIf(input, predicate);
        assertThat(Arrays.asList(1, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIfMultiple() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        Predicate<Integer> predicate = n -> n == 2;
        ListUtils.removeIf(input, predicate);
        assertThat(Arrays.asList(1, 3), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        Predicate<Integer> predicate = n -> n == 2;
        ListUtils.replaceIf(input, predicate,1);
        assertThat(Arrays.asList(1, 1, 1, 3), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> elements = new ArrayList<>(Arrays.asList(2, 3));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(1, 4), Is.is(input));
    }


}