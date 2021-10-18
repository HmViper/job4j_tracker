package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

@Ignore
public class TrackerTest {
    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(0).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenSortingAscendingById() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third = new Item("Third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> result = new ArrayList<Item>(tracker.findAll());
        Collections.sort(result, new SortByIdAsc());
        List<Item> expected = Arrays.asList(new Item("First", 1),
                new Item("Second", 2), new Item("Third", 3));
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortingDescendingById() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third = new Item("Third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> result = new ArrayList<Item>(tracker.findAll());
        Collections.sort(result, new SortByIdDesc());
        List<Item> expected = Arrays.asList(new Item("Third", 3),
                new Item("Second", 2), new Item("First", 1));
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortingAscendingByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("One");
        Item second = new Item("Two");
        Item third = new Item("Three");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> result = new ArrayList<Item>(tracker.findAll());
        Collections.sort(result, new SortByNameAsc());
        List<Item> expected = Arrays.asList(new Item("One", 1),
                new Item("Three", 3), new Item("Two", 2));
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortingDescendingByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("One");
        Item second = new Item("Two");
        Item third = new Item("Three");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> result = new ArrayList<Item>(tracker.findAll());
        Collections.sort(result, new SortByNameDesc());
        List<Item> expected = Arrays.asList(new Item("Two", 2),
                new Item("Three", 3), new Item("One", 1));
        assertThat(result, is(expected));
    }


}