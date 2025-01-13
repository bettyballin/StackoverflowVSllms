/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public static class ContactsListComparator.ContactsListComparatorImpl
implements Comparator<Contact> {
    @Override
    public int compare(Contact contact, Contact contact2) {
        int n = contact.get_contactFirstName().compareTo(contact2.get_contactFirstName());
        if (n == 0) {
            n = contact.get_contactLastName().compareTo(contact2.get_contactLastName());
        }
        return n;
    }
}
