package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private boolean doHeartSurgery;
    public Surgeon(String name, String surname, String education, int birthday, boolean doHeartSurgery) {
        super(name, surname, education, birthday);
        this.doHeartSurgery = doHeartSurgery;

    }

    void doSurgery(Patient patient, Diagnosis diagnosis) {
    }
}
