package ru.job4j.tracker;

import java.awt.image.DirectColorModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private int ids = 1;

    private List<Item> items = new ArrayList<Item>();

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<Item>();
        for (Item copyItem : items) {
            if (key.equals(copyItem.getName())) {
                result.add(copyItem);
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.set(id, item);
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            rsl = true;
        }
        return rsl;
    }
}