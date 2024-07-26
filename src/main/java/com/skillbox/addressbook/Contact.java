package com.skillbox.addressbook;

import java.util.Objects;

public class Contact {

    private static final String SPACE_REGEX = "\\s+";
    private final String name;
    private final String position;
    private final String birthday;
    private final String email;
    private final String phone;

    public Contact(String name, String position, String birthday, String email, String phone) {
        this.name = name;
        this.position = position;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(name.toLowerCase().replaceAll(SPACE_REGEX, ""), contact.name.toLowerCase().replaceAll(
                SPACE_REGEX, ""));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase().replaceAll(SPACE_REGEX, ""));
    }

    @Override
    public String toString() {
        return "ФИО: " + name + "\n" +
                "Должность: " + position + "\n" +
                "Дата рождения: " + birthday + "\n" +
                "Телефон: " + phone + "\n" +
                "Электронная почта: " + email + "\n";
    }

    public String getName() {
        return name;
    }
}
