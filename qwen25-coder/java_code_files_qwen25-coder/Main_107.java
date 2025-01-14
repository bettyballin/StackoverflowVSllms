import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

class Recipient {
    private String id;
    private String name;

    public Recipient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipient recipient = (Recipient) o;
        return Objects.equals(id, recipient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Recipient{id='" + id + "', name='" + name + "'}";
    }
}

public class Main_107 {
    public static void main(String[] args) {
        List<Recipient> recipientList = new ArrayList<>();
        recipientList.add(new Recipient("1", "Alice"));
        recipientList.add(new Recipient("2", "Bob"));
        recipientList.add(new Recipient("1", "Alice")); // Duplicate ID to test distinct()

        List<Recipient> distinctRecipients = recipientList.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctRecipients);
    }
}