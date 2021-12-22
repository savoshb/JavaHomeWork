package com.pb.savosh.hw12;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        System.out.println("Введите действие:");
        act = scan.nextLine();
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
//                contacts.remove(remove);
                contacts.entrySet().removeIf(entry -> entry.getKey().equals(remove));

// сортировка по имени
            } else if (act.equals("1")) {
                contacts.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .map(s -> s.getValue())
                        .forEach(System.out::println);
// сортировка по фамилии
            } else if (act.equals("2")) {
                List<Person> values = new ArrayList(contacts.values());
                values.stream()
                        .sorted(Comparator.comparing(Person::getName))
                        .forEach(System.out::print);

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
//                        person.setPhone(phone);
                        List<Person> phones = new ArrayList<>(contacts.values());
                        phones.stream()
                                .filter(p -> p.equals(person))
                                .forEach(p -> p.setPhone(phone));

                        System.out.println("Номер отредактирован! " + "Время: " + person.getTime() +
                                "\nЧто хотите сделать дальше?");
                        break;
                    case "fullname":
                        System.out.println("Введите новое ФИО:");
                        String fullName = scan.nextLine();
//                        person.setName(fullName);
                        List<Person> fullNames = new ArrayList<>(contacts.values());
                        fullNames.stream()
                                .filter(f -> f.equals(person))
                                .forEach(f -> f.setName(fullName));

                        System.out.println("ФИО отредактировано! " + "Время: " + person.getTime() +
                                "\nЧто хотите сделать дальше?");
                        break;
                    case "address":
                        System.out.println("Введите новый адрес:");
                        String address = scan.nextLine();
//                        person.setAddress(address);
                        List<Person> adds = new ArrayList<>(contacts.values());
                        adds.stream()
                                .filter(a -> a.equals(person))
                                .forEach(a -> a.setName(address));
                        System.out.println("Адрес отредактирован! " + "Время: " + person.getTime() +
                                "\nЧто хотите сделать дальше?");
                        break;
                    case "birth":
                        System.out.println("Введите новую дату рождения в формате (YYYY-MM-DD):");
                        String birth = scan.nextLine();
//                        person.setBirth(LocalDate.parse(birth));
                        List<Person> births = new ArrayList<>(contacts.values());
                        births.stream()
                                .filter(b -> b.equals(person))
                                .forEach(b -> b.setBirth(LocalDate.parse(birth)));
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
                contacts.entrySet().stream()
                        .filter(s -> search.equalsIgnoreCase(s.getKey()))
                        .map(s -> s.getValue())
                        .forEach(System.out::println);

            } else {
                System.out.println("Такой команды не существует!");
            }
            act = scan.nextLine();
        }
    }
}





