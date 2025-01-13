import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class PhonebookEntryList implements List<PhonebookEntry> {
    private List<PhonebookEntry> internalList = new ArrayList<>();

    public PhonebookEntryList(String filename) throws IOException {
        loadListFromFilename(filename);
    }

    public void saveListToFilename(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (PhonebookEntry entry : internalList) {
                writer.write(entry.toString() + "\n");
            }
        }
    }

    private void loadListFromFilename(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming PhonebookEntry has a constructor that takes a string
                internalList.add(new PhonebookEntry(line));
            }
        }
    }

    // Implement all the List interface methods
    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return internalList.contains(o);
    }

    @Override
    public Object[] toArray() {
        return internalList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return internalList.toArray(a);
    }

    @Override
    public boolean add(PhonebookEntry phonebookEntry) {
        return internalList.add(phonebookEntry);
    }

    @Override
    public boolean remove(Object o) {
        return internalList.remove(o);
    }

    @Override
    public boolean containsAll(List<?> c) {
        return internalList.containsAll(c);
    }

    @Override
    public boolean addAll(List<? extends PhonebookEntry> c) {
        return internalList.addAll(c);
    }

    @Override
    public boolean addAll(int index, List<? extends PhonebookEntry> c) {
        return internalList.addAll(index, c);
    }

    @Override
    public boolean removeAll(List<?> c) {
        return internalList.removeAll(c);
    }

    @Override
    public boolean retainAll(List<?> c) {
        return internalList.retainAll(c);
    }

    @Override
    public void clear() {
        internalList.clear();
    }

    @Override
    public PhonebookEntry get(int index) {
        return internalList.get(index);
    }

    @Override
    public PhonebookEntry set(int index, PhonebookEntry element) {
        return internalList.set(index, element);
    }

    @Override
    public void add(int index, PhonebookEntry element) {
        internalList.add(index, element);
    }

    @Override
    public PhonebookEntry remove(int index) {
        return internalList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return internalList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return internalList.lastIndexOf(o);
    }

    public static void main(String[] args) {
    }
}