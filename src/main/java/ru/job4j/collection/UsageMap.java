package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mail@mail.ru", "Иванов Иван Иванович");
        map.put("mail1@mail.ru", "Петров Петр Петрович");
        map.put("mail2@mail.ru", "Сидоров Сидр Сидорович");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
