import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Recipient> recipientList = Arrays.asList(
            new Recipient("id1"),
            new Recipient("id2"),
            new Recipient("id1"), // duplicate id
            new Recipient("id3")
        );

        Map<String, Recipient> distinctRecipientsMap = recipientList.stream()
                .collect(Collectors.toMap(
                        Recipient::getId,
                        r -> r,
                        (r1, r2) -> r1)); // resolver for key collisions

        List<Recipient> distinctRecipients = new ArrayList<>(distinctRecipientsMap.values());

        System.out.println(distinctRecipients);
    }

    static class Recipient {
        private String id;

        public Recipient(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Recipient{id='" + id + "'}";
        }
    }
}