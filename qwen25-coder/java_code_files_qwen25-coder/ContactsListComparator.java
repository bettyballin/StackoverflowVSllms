import java.util.Comparator;

public class ContactsListComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact c1, Contact c2) {
        // Example: Sort by first name then last name
        int firstNameCompare = c1.get_contactFirstName().compareTo(c2.get_contactFirstName());
        if (firstNameCompare != 0) {
            return firstNameCompare;
        }
        return c1.get_contactLastName().compareTo(c2.get_contactLastName());
    }

    public static void main(String[] args) {
    }
}