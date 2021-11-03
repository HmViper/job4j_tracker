package ru.job4j.bank;

import java.util.Objects;

public class Account {
    /**
     * Хранение данных о реквизите и балансе счета
     */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер реквизита
     *
     * @return возвращает реквизит счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер реквизита счета
     *
     * @param requisite реквизит счета для записи
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер баланса счета
     *
     * @return баланс на счете
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер баланса счета
     *
     * @param balance устанавливаемый баланс на счете
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals для сравнения счета по реквизитам
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * переопределение метода hashCode для хранение в HashMap
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}