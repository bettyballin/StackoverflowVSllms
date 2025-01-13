import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BeanDiff {
    public static List<FieldDiff> diff(Object bean1, Object bean2) {
        List<FieldDiff> diffs = new ArrayList<>();
        if (bean1.getClass() != bean2.getClass()) {
            throw new IllegalArgumentException("Beans must be of the same type");
        }
        for (Field field : bean1.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value1 = field.get(bean1);
                Object value2 = field.get(bean2);
                if (!value1.equals(value2)) {
                    diffs.add(new FieldDiff(field.getName(), value1, value2));
                }
            } catch (IllegalAccessException e) {
                // Handle exception
            }
        }
        return diffs;
    }

    public static class FieldDiff {
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

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Object getOldValue() {
            return oldValue;
        }

        public void setOldValue(Object oldValue) {
            this.oldValue = oldValue;
        }

        public Object getNewValue() {
            return newValue;
        }

        public void setNewValue(Object newValue) {
            this.newValue = newValue;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        Person person1 = new Person("John", 30);
        Person person2 = new Person("John", 31);

        List<FieldDiff> diffs = BeanDiff.diff(person1, person2);
        for (FieldDiff diff : diffs) {
            System.out.println("Field: " + diff.getFieldName() + ", Old Value: " + diff.getOldValue() + ", New Value: " + diff.getNewValue());
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}