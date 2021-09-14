package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[size];
        int intSize = 0;
        for (int index = 0; index < size; index++) {
            Item copyItem = items[index];
            if (copyItem != null) {
                itemsWithoutNull[intSize] = copyItem;
                intSize++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, intSize);
    }

    public Item[] findByName(String key) {
        Item[] foundItemsWithName = new Item[size];
        int intSize = 0;
        for (int index = 0; index < size; index++) {
            Item copyItem = items[index];
            if (key.equals(copyItem.getName())) {
                foundItemsWithName[intSize] = copyItem;
                intSize++;
            }
        }
        return Arrays.copyOf(foundItemsWithName, intSize);
    }
}