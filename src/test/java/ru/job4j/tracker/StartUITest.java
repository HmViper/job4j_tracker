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
                "Menu:" + System.lineSeparator() +
                        "0. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Add new Item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        +  "=== Create a new Item ====" + System.lineSeparator()
                        +  "Menu:" + System.lineSeparator()
                        +  "0. Add new Item" + System.lineSeparator()
                        +  "1. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Edit item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        +  "=== Edit item ====" + System.lineSeparator()
                        + "Заявка изменена успешно." + System.lineSeparator()
                        +  "Menu:" + System.lineSeparator()
                        +  "0. Edit item" + System.lineSeparator()
                        +  "1. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Delete item" + System.lineSeparator()
                        + "1. Exit program" + System.lineSeparator()
                        +  "=== Delete item ====" + System.lineSeparator()
                        + "Заявка удалена успешно." + System.lineSeparator()
                        +  "Menu:" + System.lineSeparator()
                        +  "0. Delete item" + System.lineSeparator()
                        +  "1. Exit program" + System.lineSeparator()
        ));
    }
}