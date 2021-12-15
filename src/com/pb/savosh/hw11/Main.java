package com.pb.savosh.hw11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        String act;
        Scanner scan = new Scanner(System.in);
        HashMap<String, Person> contacts = new HashMap<>();

        contacts.put("Богдан", (new Person("Савош Богдан Александрович", "0662550610", LocalDate.of(1992, 8, 25), "Heroes ave. 12")));
        contacts.put("Алина", (new Person("Дударь Алина Андреевна", "0672040027", LocalDate.of(1995, 3, 10), "Heroes ave. 12")));
        contacts.put("Антон", (new Person("Леонов Антон Витальевич", "0631256835", LocalDate.of(1994, 5, 10), "G.Doroshenka 5")));

        System.out.println("Для добавления нового контакта введите add;" + "\n" +
                "Для удаления контакта - remove;\n" +
                "Для сортировки по имени - 1, по фамилии - 2;\n" +
                "Для поиска контакта - search;\n" +
                "Для редактирования - edit;\n" +
                "Для выхода - exit.\n" +
                "-------------------------------------------");

        for (Map.Entry me : contacts.entrySet()) {
            System.out.println("Имя контакта: " + me.getKey() + "\n" +
                    "-----------------------");
        }

        act = scan.nextLine();
        System.out.println("Введите действие:");
        while (!act.equals("exit")) {

// добавление контакта
            if (act.equals("add")) {
                System.out.println("Введите имя контакта для добавления:");
                String name = scan.nextLine();
                System.out.println("Введите номер телефона:");
                String phone = scan.nextLine();
                Person person = new Person(phone);
                contacts.put(name, person);
                System.out.println("Контакт успешно добавлен!");

// удаление контакта
            } else if (act.equals("remove")) {
                System.out.println("Введите имя контакта для удаления:");
                String remove = scan.nextLine();
                System.out.println("Контакт успешно удален!");
                contacts.remove(remove);

// сортировка по имени
            } else if (act.equals("1")) {
                TreeMap<String, Person> sorted = new TreeMap<>(contacts);
                for (Map.Entry me : sorted.entrySet()) {
                    System.out.println("Имя контакта: " + me.getKey() + "\n" + "Данные: " + me.getValue() + "\n" +
                            "-------------------------------------------");
                }
// сортировка по фамилии
            } else if (act.equals("2")) {
                List<Person> sortedList = personList(contacts);
                System.out.println(sortedList);

// редактирование контакта
            } else if (act.equals("edit")) {
                System.out.println("Введите имя контакта для редактирования:");
                String edit = scan.nextLine();
                System.out.println("Поля для редактирования(phone, fullname, address, birth)");
                String move = scan.nextLine();
                Person person = contacts.get(edit);
                switch (move) {
                    case "phone":
                        System.out.println("Введите новый номер телефона:");
                        String phone = scan.nextLine();
                        person.setPhone(phone);
                        System.out.println("Номер отредактирован! " + "Время: " + person.getTime() +
                                "\nЧто хотите сделать дальше?");
                        break;
                    case "fullname":
                        System.out.println("Введите новое ФИО:");
                        String fullName = scan.nextLine();
                        person.setName(fullName);
                        System.out.println("ФИО отредактировано! " + "Время: " + person.getTime() +
                                "\nЧто хотите сделать дальше?");
                        break;
                    case "address":
                        System.out.println("Введите новый адрес:");
                        String address = scan.nextLine();
                        person.setAddress(address);
                        System.out.println("Адрес отредактирован! " + "Время: " + person.getTime() +
                                "\nЧто хотите сделать дальше?");
                        break;
                    case "birth":
                        System.out.println("Введите новую дату рождения в формате (YYYY-MM-DD):");
                        String birth = scan.nextLine();
                        person.setBirth(LocalDate.parse(birth));
                        System.out.println("Дата рождения отредактирована! " + "Время: " + person.getTime() +
                                "\nЧто хотите сделать дальше?");
                }
// сохранение в файл
            } else if (act.equals("save")) {
                writer.writeValue(new File("files/contacts.json"), contacts);
                System.out.println("Файл записан.");
            }
// чтение из файла
            else if (act.equals("read")) {
                HashMap<String, Person> persons = mapper.readValue(new File("files/contacts.json"), new TypeReference<HashMap<String, Person>>() {
                });
                System.out.println("Файл прочитан.");
                contacts.putAll(persons);
                for (Map.Entry me : persons.entrySet()) {
                    System.out.println("Имя контакта: " + me.getKey() + "\n" +
                            "-----------------------");
                }
            }
// поиск контакта
            else if (act.equals("search")) {
                System.out.println("Введите имя контакта для поиска:");
                String search = scan.nextLine();
                System.out.println(contacts.get(search));
            } else {
                System.out.println("Такой команды не существует!");
            }
            act = scan.nextLine();
        }
    }

    public static List<Person> personList(HashMap<String, Person> contacts) {
        if (contacts != null) {
            List<Person> values = new ArrayList();
            values.addAll(contacts.values());
            Collections.sort(values, new Comparator<Person>() {
                public int compare(Person o1, Person o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            return values;
        }
        return null;
    }
}







