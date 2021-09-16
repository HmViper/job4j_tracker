package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String input = scanner.nextLine();
        int answer = new Random().nextInt(3);
        String answerString = switch (answer) {
            case 1 -> "Да";
            case 2 -> "Нет";
            default -> "Возможно";
        };
        System.out.println(answerString);
    }
}
