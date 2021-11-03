package ru.job4j.bank;

import java.util.Objects;

public class User {
    /**
     * Хранение данных паспорта и ФИО клиента
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер для получения паспорта клиента
     *
     * @return паспорт клиента
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для записи паспорта
     *
     * @param passport - паспорт который добавляется для записи
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер для получения ФИО клиента
     *
     * @return возвращает ФИО клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для записи ФИО клиента
     *
     * @param username ФИО записываемого клиента
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода equals для сравнения по паспорту
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода hashCode для хранение в HashMap
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}