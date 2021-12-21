package com.pb.savosh.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private LocalDate birth;
    private String phone;
    private String address;
    private LocalDateTime time;

    public Person(String name, String phone, LocalDate birth, String address) {
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.address = address;
        this.time = LocalDateTime.now();
    }

    public Person(String phone) {
        this.phone = phone;
        this.time = LocalDateTime.now();
    }

    public Person () {
        this.time = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        LocalDateTime.now();
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
        LocalDateTime.now();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        LocalDateTime.now();
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
        LocalDateTime.now();
    }

    @Override
    public String toString() {
        return '\n' + "ФИО:'" + name + '\'' +
                ", ДР: " + birth +
                ", телефон: '" + phone + '\'' +
                ", адрес: '" + address + '\'' +
                ", время редактирования: '" + time + '\'';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(birth, person.birth) && Objects.equals(phone, person.phone) && Objects.equals(address, person.address) && Objects.equals(time, person.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birth, phone, address, time);
    }

    @Override
    public int compareTo(Person person) {
        return 0;
    }
}


