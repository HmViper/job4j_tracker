package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    public Surgeon(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    void doSurgery(Patient patient, Diagnosis diagnosis) {
    }
}
