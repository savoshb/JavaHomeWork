package com.pb.savosh.hw5;

public class Library {
    public static void main(String[] args) {

        Book[] books = new Book[3];
        books[0] = new Book("Приключения", "Иванов И.И.", "2000");
        books[1] = new Book("Словарь", "Сидоров А.В.", "1980");
        books[2] = new Book("Энциклопедия", "Гусев К.В.", "2010");


        for (Book book : books) {
            System.out.println(book.getInfoBook());
        }
        System.out.println();

        Reader[] readers = new Reader[3];
        readers[0] = new Reader("Савош Б.А.", "123", "ФТФ", "1992", "0662550610");
        readers[1] = new Reader("Дударь А.А.", "234", "эко", "1995", "0672040027");
        readers[2] = new Reader("Иванов И.И.", "345", "филолог", "2000", "0633080028");

        for (Reader reader : readers) {
            System.out.println(reader.getInfoReader());
        }
        System.out.println();

        readers[0].takeBook(3);
        readers[1].takeBook(books[0].getTitle(), books[1].getTitle(), books[2].getTitle());
        System.out.print("\n");
        readers[2].takeBook(books[1], books[2]);
        System.out.println();

        readers[0].returnBook(3);
        readers[1].returnBook(books[0].getTitle(), books[1].getTitle(), books[2].getTitle());
        System.out.print("\n");
        readers[2].returnBook(books[1], books[2]);
        System.out.print("\b" + "\b" +".");

    }
}
