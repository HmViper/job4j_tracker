package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Student student = new Student();
        student.setFio("Петров Петр Александрович");
        student.setGroup(1);
        student.setDateOfReceipt(LocalDateTime.of(2020, 6, 12, 12, 20, 20));
        System.out.println("ФИО: " + student.getFio());
        System.out.println("Группа" + student.getGroup());
        System.out.println("Дата поступления:" + student.getDateOfReceipt().format(formatter));
    }
}
