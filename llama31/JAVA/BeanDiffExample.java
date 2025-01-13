import java.util.List;

class MyBean {
    private String name;
    private int value;

    public MyBean(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}

class FieldDiff {
    private String fieldName;
    private Object oldValue;
    private Object newValue;

    public FieldDiff(String fieldName, Object oldValue, Object newValue) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}

class BeanDiff {
    public static List<FieldDiff> diff(MyBean bean1, MyBean bean2) {
        // This method is not implemented, as the logic to calculate differences is not provided
        // For the sake of this example, it returns an empty list
        return List.of();
    }
}

public class BeanDiffExample {
    public static void main(String[] args) {
        MyBean bean1 = new MyBean("name1", 1);
        MyBean bean2 = new MyBean("name2", 2);

        List<FieldDiff> diffs = BeanDiff.diff(bean1, bean2);
        for (FieldDiff diff : diffs) {
            System.out.println(diff.getFieldName() + ": " + diff.getOldValue() + " -> " + diff.getNewValue());
        }
    }
}