package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean canRemoveTooth;

    public Dentist(String name, String surname, String education,
                   int birthday, boolean canRemoveTooth) {
        super(name, surname, education, birthday);
        this.canRemoveTooth = canRemoveTooth;
    }

    void treatTooth(Patient patient, Diagnosis diagnosis) {
    }
}
