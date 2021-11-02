package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String languageSpeciality;

    public Programmer(String name, String surname, String education, int birthday,
                      int classOfEngineer, String languageSpeciality) {
        super(name, surname, education, birthday, classOfEngineer);
        this.languageSpeciality = languageSpeciality;
    }

    void build(Program program) {

    }
}
