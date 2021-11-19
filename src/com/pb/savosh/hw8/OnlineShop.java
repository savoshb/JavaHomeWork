package com.pb.savosh.hw8;


public class OnlineShop {
    public static void main(String[] args) {

        Auth user = new Auth();

        try {
            user.signUp("", "", "");
            user.signIn("", "");

        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println("Ошибка! " + ex.getMessage());
        }
    }
}
