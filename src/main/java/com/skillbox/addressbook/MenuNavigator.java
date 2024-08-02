package com.skillbox.addressbook;

import java.util.Scanner;

public class MenuNavigator {

    private static final int NEW_CONTACT_OPTION = 1;
    private static final int REMOVE_CONTACT_OPTION = 2;
    private static final int PRINT_CONTACTS_OPTION = 3;
    private static final int EXIT_OPTION = 4;
    private final AddressBook addressBook = new AddressBook();
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public void start() {
        while (true) {
            int i = selectMainMenu();
            switch (i) {
                case NEW_CONTACT_OPTION:
                    newContact();
                    break;
                case REMOVE_CONTACT_OPTION:
                    removeContact();
                    break;
                case PRINT_CONTACTS_OPTION:
                    printContacts();
                    break;
                case EXIT_OPTION:
                    exit();
            }
        }
    }

    private void printContacts() {
        System.out.println(addressBook);
    }

    private void removeContact() {
        System.out.println("\nУдаление существующего контакта.\n");
        System.out.print("Введите ID контакта: ");
        int id = scanner.nextInt();
        Contact contact = addressBook.getContact(id);
        if (contact == null) {
            System.out.println("Контакт с ID: " + id + " не найден.\n");
        } else {
            addressBook.removeContact(id);
            System.out.println("Контакт с ID: " + id + " удален.\n");
        }
    }

    private void newContact() {
        System.out.println("\nНовый контакт.\n");
        System.out.print("Введите ФИО контакта: ");
        String name = scanner.next();
        System.out.print("Должность: ");
        String position = scanner.next();
        System.out.print("Дата рождения: ");
        String birthday = scanner.next();
        System.out.print("Телефон: ");
        String phone = scanner.next();
        System.out.print("Электронная почта: ");
        String email = scanner.next();

        Contact contact = new Contact(name, position, birthday, phone, email);

        int existPos = addressBook.contains(contact);
        if (existPos >= 0) {
            addressBook.addContact(existPos, contact);
            System.out.println("Контакт \"" + name + "\" обновлен.\n");
        } else {
            addressBook.addContact(contact);
            System.out.println("Контакт \"" + name + "\" добавлен.\n");
        }
    }

    private void exit() {
        scanner.close();
        System.exit(0);
    }

    private int selectMainMenu() {
        int option;

        while (true) {
            System.out.print("\nАдресная книга\n"
                    + "\n"
                    + NEW_CONTACT_OPTION + " – новый контакт\n"
                    + REMOVE_CONTACT_OPTION + " – удаление существующего контакта\n"
                    + PRINT_CONTACTS_OPTION + " – вывод всех контактов\n"
                    + EXIT_OPTION + " – завершение работы\n"
                    + "\n"
                    + "Введите нужную опцию и нажмите Enter [1..4]: ");

            option = scanner.nextInt();
            if (option > 0 && option < 5) {
                break;
            }
            System.out.println("Выбрана неверная опция!\n"
                    + "Попробуйте заново.\n");

        }
        return option;
    }
}
