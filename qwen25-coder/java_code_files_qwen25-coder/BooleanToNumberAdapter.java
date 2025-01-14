public abstract class XmlAdapter<ValueType, BoundType> {
    public abstract ValueType marshal(BoundType v) throws Exception;
    public abstract BoundType unmarshal(ValueType v) throws Exception;
}

public class BooleanToNumberAdapter extends XmlAdapter<Integer, Boolean> {

    @Override
    public Integer marshal(Boolean v) throws Exception {
        return (v != null && v) ? 1 : 0;
    }

    @Override
    public Boolean unmarshal(Integer v) throws Exception {
        return (v != null && v == 1);
    }

    public static void main(String[] args) throws Exception {
        BooleanToNumberAdapter adapter = new BooleanToNumberAdapter();
        int marshalled = adapter.marshal(true);
        System.out.println("marshal(true) = " + marshalled);

        boolean unmarshalled = adapter.unmarshal(1);
        System.out.println("unmarshal(1) = " + unmarshalled);
    }
}