package com.pb.savosh.hw5;

public class Reader {
    private String name;
    private String ticket;
    private String fac;
    private String birth;
    private String phone;


    String getInfoReader() {
        return "ФИО: " + name + "; № билета: " + ticket + "; факультет: " + fac +
                "; дата рождения: " + birth + "; телефон: " + phone;
    }

    public Reader(String name, String ticket, String fac, String birth, String phone) {
        this.name = name;
        this.ticket = ticket;
        this.fac = fac;
        this.birth = birth;
        this.phone = phone;
    }


    public void takeBook(int count) {
        System.out.println(name + " взял " + count + " книги.");
    }

    public void takeBook(String... titles) {
        System.out.print(name + " взял(а) книги: ");
        for (String title : titles) {
            System.out.print(title + "; ");
        }
    }

    public void takeBook(Book... titles2) {
        System.out.print(name + " взял(а) книги: ");
        for (Book title2 : titles2) {
            System.out.print(title2.getInfoBook() + "; ");
        }
    }

    public void returnBook(int count) {
        System.out.println(name + " вернул " + count + " книги.");
    }

    public void returnBook(String... titles) {
        System.out.print(name + " вернул(а) книги: ");
        for (String title : titles) {
            System.out.print(title + "; ");
        }
    }

    public void returnBook(Book... titles2) {
        System.out.print(name + " вернул(а) книги: ");
        for (Book title2 : titles2) {
            System.out.print(title2.getInfoBook() + "; ");
        }

    }
}
