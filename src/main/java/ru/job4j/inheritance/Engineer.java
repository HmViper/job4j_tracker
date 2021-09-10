package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int classOfEngineer;

    public Engineer(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public int getClassOfEngineer() {
        return classOfEngineer;
    }

}


