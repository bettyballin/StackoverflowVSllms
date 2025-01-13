/*
 * Decompiled with CFR 0.152.
 */
public class AddressBookService {
    public Address addAddress(Address address) throws PersistenceException {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        System.out.println("Adding address to database...");
        return address;
    }

    public static void main(String[] stringArray) {
        AddressBookService addressBookService = new AddressBookService();
        Address address = new Address("123 Main St", "Anytown", "CA", "12345");
        try {
            addressBookService.addAddress(address);
        }
        catch (PersistenceException persistenceException) {
            System.out.println("Error adding address: " + persistenceException.getMessage());
        }
    }
}
