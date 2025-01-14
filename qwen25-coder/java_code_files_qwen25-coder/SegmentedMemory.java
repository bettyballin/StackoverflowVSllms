import java.lang.String;
// Example: A simplified simulation of segmented memory where each segment holds specific type of data

public class SegmentedMemory {
    private String[] codeSegment;
    private int[] dataSegment;

    public SegmentedMemory(int maxCodeStatements, int maxDataEntries) {
        this.codeSegment = new String[maxCodeStatements];
        this.dataSegment = new int[maxDataEntries];
    }

    public void storeCode(String code, int index) {
        if (index < codeSegment.length) {
            codeSegment[index] = code;
        } else {
            throw new IndexOutOfBoundsException("Code segment index out of bounds");
        }
    }

    public void storeData(int data, int index) {
        if (index < dataSegment.length) {
            dataSegment[index] = data;
        } else {
            throw new IndexOutOfBoundsException("Data segment index out of bounds");
        }
    }

    public String getCode(int index) {
        return codeSegment[index];
    }

    public int getData(int index) {
        return dataSegment[index];
    }

	public static void main(String[] args) {
	}
}