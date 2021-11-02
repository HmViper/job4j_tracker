package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int classOfEngineer;

    public Engineer(String name, String surname, String education,
                    int birthday, int classOfEngineer) {
        super(name, surname, education, birthday);
        this.classOfEngineer = classOfEngineer;
    }

    public int getClassOfEngineer() {
        return classOfEngineer;
    }

}


