public class MyClass {

    public static void main(String[] args) {
        Attributes attributes = new Attributes();   // The attributes for your entity

        String someEntryUUID = "someEntryUUIDValue";
        String entryUUID = "entryUUIDValue";
        String someDnWithForm = "someDnWithFormValue";

        attributes.setAttribute("entryUUID", someEntryUUID);
        attributes.setNameInNamespace(someDnWithForm + "/" + entryUUID);

        Entry entry = new Entry();

        if (!entry.getOptions().isUpdateEntryUUID()) {
            entry.updateAttributeValue("objectClass", "entryUUID");
        }
    }
}

class Attributes {
    public void setAttribute(String key, String value) {
        // implementation not necessary
    }
    public void setNameInNamespace(String name) {
        // implementation not necessary
    }
}

class Entry {
    public Options getOptions() {
        return new Options();
    }
    public void updateAttributeValue(String key, String value) {
        // implementation not necessary
    }
}

class Options {
    public boolean isUpdateEntryUUID() {
        return false;
    }
}