public class Main {
    public static void main(String[] args) throws Exception {
        // Create instance of address book protobuf class
        AddressBook ab = AddressBook.newBuilder().build();

        // Serialize to bytes
        byte[] data = ab.toByteArray();

        // Deserialize from bytes back into an in-memory object.
        AddressBook result = AddressBook.parseFrom(data);
    }
}

// Minimal AddressBook class for compilation
class AddressBook {
    public static Builder newBuilder() {
        return new Builder();
    }

    public byte[] toByteArray() {
        return new byte[0];
    }

    public static AddressBook parseFrom(byte[] data) {
        return new AddressBook();
    }

    public static class Builder {
        public AddressBook build() {
            return new AddressBook();
        }
    }
}