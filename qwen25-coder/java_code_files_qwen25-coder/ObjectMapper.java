import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ObjectMapper {
    private Map<Object, Object> map;

    public ObjectMapper() {
        map = new HashMap<>();
    }

    public void addMapping(int index, UUID uuid) {
        map.put(uuid, index);
        map.put(index, uuid);
    }

    public Integer getIndexByUUID(UUID uuid) {
        Object result = map.get(uuid);
        return (result instanceof Integer) ? (Integer) result : null;
    }

    public UUID getUUIDByIndex(Integer index) {
        Object result = map.get(index);
        return (result instanceof UUID) ? (UUID) result : null;
    }

    public static void main(String[] args) {
    }
}