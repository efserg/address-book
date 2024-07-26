package com.skillbox.addressbook;

public class AddressBook {

    private final Contact[] contacts;

    private static final int MAX_CONTACTS = 100;
    public AddressBook() {
        this.contacts = new Contact[MAX_CONTACTS];
    }

    public int contains(Contact contact) {
        for (int i = 0; i < MAX_CONTACTS; i++) {
            if (contact.equals(contacts[i])) {
                return i;
            }
        }
        return -1;
    }

    public void addContact(Contact contact) {
        for (int i = 0; i < MAX_CONTACTS; i++) {
            if (contacts[i] == null) {
                contacts[i] = contact;
                break;
            }
        }
    }
    public void addContact(int position, Contact contact) {
        contacts[position] = contact;
    }

    public void removeContact(int id) {
        contacts[id] = null;
    }

    public Contact getContact(int position) {
        return contacts[position];
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nКонтакты, имеющиеся в адресной книге:\n\n");
        for (int i = 0; i < MAX_CONTACTS; i++) {
            if (contacts[i] != null) {
                sb.append("ID: ").append(i).append("\n")
                        .append(contacts[i])
                        .append("\n\n");
            }
        }
        return sb.toString();
    }
}
