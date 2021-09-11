package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class Student {
    private String fio;
    private int group;
    private LocalDateTime dateOfReceipt;

    public String getFio() {
        return fio;
    }

    public int getGroup() {
        return group;
    }

    public LocalDateTime getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setDateOfReceipt(LocalDateTime dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }
}
