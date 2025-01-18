// Missing interfaces

interface InputNode {
    InputNode getNext(String name) throws Exception;
    String getValue() throws Exception;
}

interface OutputNode {
    OutputNode getChild(String name) throws Exception;
    void setValue(String value) throws Exception;
}

interface Converter<T> {
    T read(InputNode node) throws Exception;
    void write(OutputNode node, T value) throws Exception;
}

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LanguageConverter implements Converter<List<String>> {
    @Override
    public List<String> read(InputNode node) throws Exception {
        InputNode next = node.getNext("lang");
        if (next == null) return Collections.emptyList();
        List<String> langs = new ArrayList<>();

        while (true) {
            String language = next.getValue();
            langs.add(language);
            next = next.getNext("lang");
            if (next != null) continue;
            break;
        }
        return langs;
    }

    @Override
    public void write(OutputNode node, List<String> value) throws Exception {
        for (String lang : value) {
            OutputNode langNode = node.getChild("lang");
            langNode.setValue(lang);
        }
    }
}