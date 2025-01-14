import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = MockMessage.class, name = "MockMessage"),
    @JsonSubTypes.Type(value = MockMessageOther.class, name = "MockMessageOther")
})
class Message {
    // Base class can contain common properties
}

class MockMessage extends Message {
    int val = 1;
}

class MockMessageOther extends Message {
    int otherVal = 1;
    int val = 2; // to differentiate it more in the example output
}

public class Main_24 {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<Message> messages = new ArrayList<>();
        messages.add(new MockMessage());
        messages.add(new MockMessage());
        messages.add(new MockMessageOther());

        // Serialize to JSON
        String json = mapper.writeValueAsString(messages);
        System.out.println("Serialized JSON: " + json);

        // Deserialize back to Java objects list
        List<Message> deserializedMessages = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Message.class));
        System.out.println("Deserialized messages count: " + deserializedMessages.size());
    }
}