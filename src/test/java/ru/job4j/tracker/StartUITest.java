package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void findAllActionTest() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("test"));
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "=== Show all items ====" + System.lineSeparator()
                        + tracker.findAll()[0] + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Show all items" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void findByNameTest() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "test", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("test"));
        UserAction[] actions = {
                new FindItemByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "=== Find items by name ====" + System.lineSeparator()
                        + tracker.findAll()[0] + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void findByIdTest() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("test"));
        UserAction[] actions = {
                new FindItemByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + tracker.findAll()[0] + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
        ));
    }

}