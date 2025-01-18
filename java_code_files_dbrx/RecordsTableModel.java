import javax.swing.table.AbstractTableModel;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class RecordsTableModel extends AbstractTableModel {
    private List<Record> records = new ArrayList<>();

    @Override
    public int getRowCount() {
        return records.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // Number of columns in the table: name, age, city and date
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Record record = records.get(rowIndex);
        switch (columnIndex){
            case 0: return record.getName();
            case 1: return record.getAge(); // for simplicity consider only as an integer data type here, in real life implementations may vary depending on use-case
            case 2: return record.getCity();
            default: return record.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "Person Name";
            case 1: return "Age";
            case 2: return "City";
            case 3: return "Date";
            default: return super.getColumnName(column);
        }
    }

    public void addRecord (Record record) {
         records.add(record); // Here you should fire a new insert event to notify the table for updates (TableChangedEvent).
                              // However I'm leaving this to keep example simple and understandable, but in real code don't forget about it!
    }
}

// Supporting Record class
class Record {
    private String name;
    private int age;
    private String city;
    private LocalDateTime date;

    public Record(String name, int age, String city, LocalDateTime date){
        this.name = name;
        this.age = age;
        this.city = city;
        this.date = date;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getCity(){
        return city;
    }

    public LocalDateTime getDate(){
        return date;
    }
}