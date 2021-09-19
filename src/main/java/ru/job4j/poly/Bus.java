package ru.job4j.poly;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Я автобус я и еду по шоссе");
    }
}
