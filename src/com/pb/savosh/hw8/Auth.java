package com.pb.savosh.hw8;

import java.util.Scanner;

public class Auth {

    private String login;
    private String password;
    Scanner scan = new Scanner(System.in);

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        System.out.println("Придумайте логин:");
        login = scan.nextLine();

        if (login.length() < 5 | login.length() > 20) {
            throw new WrongLoginException("Логин неподходящей длины!");
        } else if (!login.matches("[a-zA-Z0-9]+")) {
            throw new WrongLoginException("Логин содержит недопустимые символы!");
        }

        System.out.println("Придумайте пароль:");
        password = scan.nextLine();

        if (password.length() < 5) {
            throw new WrongPasswordException("Пароль слишком короткий!");
        } else if (!password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы!");
        }
        System.out.println("Подтвердите пароль:");
        confirmPassword = scan.nextLine();
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
        this.login = login;
        this.password = password;

        System.out.println("Пользователь успешно зарегистрирован!");
        System.out.println("Логин: " + login + "; Пароль: " + password);
    }

    public void signIn(String login, String password) throws WrongLoginException {
        System.out.println("---------------------------------");
        System.out.println("Вход в систему..." + "\n" + "Введите логин: ");
        login = scan.nextLine();
        System.out.println("Введите пароль:");
        password = scan.nextLine();

        if (!login.equals(this.login) || !password.equals(this.password)) {
            throw new WrongLoginException("Логин или пароль введены неверно!");
        } else {
            System.out.println("Вы успешно вошли в систему!");
        }
    }
}




