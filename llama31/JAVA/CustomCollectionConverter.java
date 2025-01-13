import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CustomCollectionConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return Collection.class.isAssignableFrom(type);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        List list = (List) source;
        writer.startNode("list");
        for (Object item : list) {
            writer.startNode(item.getClass().getSimpleName());
            context.convertAnother(item);
            writer.endNode();
        }
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        List list = new ArrayList();
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            String className = reader.getNodeName();
            try {
                Object item = context.convertAnother(null, Class.forName(className));
                list.add(item);
            } catch (ClassNotFoundException e) {
                // Handle the exception
            }
            reader.moveUp();
        }
        return list;
    }

    public static void main(String[] args) {
        // You need to have some code here to test the class
        // For example:
        CustomCollectionConverter converter = new CustomCollectionConverter();
        System.out.println(" converter created ");
    }
}