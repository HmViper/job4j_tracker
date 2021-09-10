package ru.job4j.inheritance;

public class Programmer extends Engineer{
    public Programmer(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    Task build(Program program){}
}
