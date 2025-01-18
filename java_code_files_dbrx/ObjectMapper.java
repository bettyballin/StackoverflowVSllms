import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ObjectMapper {
    private Map<UUID, Integer> mapper; // Mapping from UUID to Integer
    private Map<Integer, UUID> inverseMapper; // Mapping from Integer to UUID

    public ObjectMapper() {
        mapper = new HashMap<>();
        inverseMapper = new HashMap<>();
    }

    public void addMapping(int index, UUID uuid){
        this.mapper.put(uuid, index);
        this.inverseMapper.put(index, uuid);
    }

    public Integer getIndexByUUID(UUID uuid) {
        return mapper.get(uuid);
    }

    public UUID getUUIDByIndex(Integer index){
       return this.inverseMapper.get(index);
    }
}