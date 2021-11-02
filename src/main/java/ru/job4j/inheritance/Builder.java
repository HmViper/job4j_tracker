package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String speciality;

    public Builder(String name, String surname, String education, int birthday,
                   int classOfEngineer, String speciality) {
        super(name, surname, education, birthday, classOfEngineer);
        this.speciality = speciality;
    }

    void build(House house) {
    }
}
