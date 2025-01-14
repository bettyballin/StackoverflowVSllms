import java.util.*;
import java.util.stream.Collectors;

public class Main_108 {
    public static void main(String[] args) {
        List<Recipient> recipientList = new ArrayList<>();
        recipientList.add(new Recipient("1", "Alice"));
        recipientList.add(new Recipient("2", "Bob"));
        recipientList.add(new Recipient("1", "Alice Duplicate"));
        recipientList.add(new Recipient("3", "Charlie"));
        recipientList.add(new Recipient("2", "Bob Duplicate"));

        Set<String> seenIds = new HashSet<>();
        List<Recipient> distinctRecipients = recipientList.stream()
                .filter(recipient -> seenIds.add(recipient.getId())) // assumes getId() identifies the object
                .collect(Collectors.toList());

        System.out.println(distinctRecipients);
    }
}

class Recipient {
    private String id;
    private String name;

    public Recipient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Recipient{id='" + id + "', name='" + name + "'}";
    }
}