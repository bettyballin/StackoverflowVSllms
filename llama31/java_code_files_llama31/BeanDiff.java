/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BeanDiff {
    public static List<FieldDiff> diff(Object object, Object object2) {
        ArrayList<FieldDiff> arrayList = new ArrayList<FieldDiff>();
        if (object.getClass() != object2.getClass()) {
            throw new IllegalArgumentException("Beans must be of the same type");
        }
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object object3 = field.get(object);
                Object object4 = field.get(object2);
                if (object3.equals(object4)) continue;
                arrayList.add(new FieldDiff(field.getName(), object3, object4));
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        Person person = new Person("John", 30);
        Person person2 = new Person("John", 31);
        List<FieldDiff> list = BeanDiff.diff(person, person2);
        for (FieldDiff fieldDiff : list) {
            System.out.println("Field: " + fieldDiff.getFieldName() + ", Old Value: " + String.valueOf(fieldDiff.getOldValue()) + ", New Value: " + String.valueOf(fieldDiff.getNewValue()));
        }
    }

    public static class FieldDiff {
        private String fieldName;
        private Object oldValue;
        private Object newValue;

        public FieldDiff(String string, Object object, Object object2) {
            this.fieldName = string;
            this.oldValue = object;
            this.newValue = object2;
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public void setFieldName(String string) {
            this.fieldName = string;
        }

        public Object getOldValue() {
            return this.oldValue;
        }

        public void setOldValue(Object object) {
            this.oldValue = object;
        }

        public Object getNewValue() {
            return this.newValue;
        }

        public void setNewValue(Object object) {
            this.newValue = object;
        }
    }
}
