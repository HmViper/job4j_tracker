package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bible = new Book("Библия", 1217);
        Book platon = new Book("Платон.Диалоги", 576);
        Book napoleon = new Book("Евгений Тарле.Наполеон", 512);
        Book cleanCode = new Book("Robert Martin.Clean code", 464);
        Book[] library = new Book[4];
        library[0] = bible;
        library[1] = platon;
        library[2] = napoleon;
        library[3] = cleanCode;
        for (Book book : library) {
            System.out.println("Книга: " + book.getName() + ". Кол-во страниц: " + book.getPages());
        }
        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        for (Book book : library) {
            System.out.println("Книга: " + book.getName() + ". Кол-во страниц: "
                    + book.getPages());
        }
        for (Book book : library) {
            if (("Robert Martin.Clean code").equals(book.getName())) {
                System.out.println("Книга: " + book.getName() + ". Кол-во страниц: "
                        + book.getPages());
            }
        }

    }
}
