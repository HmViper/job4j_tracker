package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Я поезд и я еду по рельсам");
    }
}
