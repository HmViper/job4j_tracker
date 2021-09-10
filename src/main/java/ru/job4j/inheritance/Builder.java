package ru.job4j.inheritance;

public class Builder extends Engineer {
    public Builder(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    void build(House house) {
    }
}
