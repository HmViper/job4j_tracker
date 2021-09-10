package ru.job4j.inheritance;

public class Dentist extends Doctor {
    public Dentist(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    void treatTooth(Patient patient, Diagnosis diagnosis) {
    }
}
