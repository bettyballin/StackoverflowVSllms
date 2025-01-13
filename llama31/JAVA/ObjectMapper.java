import java.util.UUID;
import java.lang.Integer;
import java.lang.String;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class ObjectMapper {
    private BiMap<UUID, Integer> mapping;

    public ObjectMapper() {
        mapping = HashBiMap.create();
    }

    public void addMapping(int index, UUID uuid) {
        mapping.put(uuid, index);
    }

    public Integer getIndexByUUID(UUID uuid) {
        return mapping.get(uuid);
    }

    public UUID getUUIDByIndex(Integer index) {
        return mapping.inverse().get(index);
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        UUID uuid = UUID.randomUUID();
        mapper.addMapping(1, uuid);
        System.out.println(mapper.getIndexByUUID(uuid)); // prints 1
        System.out.println(mapper.getUUIDByIndex(1)); // prints the UUID
    }
}