import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompositeKeyExtractor {
    List<String> keyList = new ArrayList<>();
    Data data = new Data();

    {
        for (CompositeType.KeyInfo info : ((OpenType) data.getCompositeType()).getKeySet()) {
            keyList.add(info.getName());
        }
    }

    public static void main(String[] args) {
    }
}

class Data {
    public CompositeType getCompositeType() {
        return new CompositeType();
    }
}

class OpenType {
}

class CompositeType extends OpenType {
    public Set<KeyInfo> getKeySet() {
        return Set.of(new KeyInfo("Key1"), new KeyInfo("Key2"));
    }

    static class KeyInfo {
        private String name;

        public KeyInfo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}