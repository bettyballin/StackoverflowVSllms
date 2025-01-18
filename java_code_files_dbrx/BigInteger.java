import java.util.ArrayList;
import java.lang.Math;

public class BigInteger {
    private static final int WORD_SIZE = 32; // 1 word size = 32 bits in this case, which can store a value up to MAX[2^32 - 1]
    private boolean isNegative;         // sign of the number (false for positive numbers and true for negative numbers)
    private ArrayList<Integer> values;   // each value represents one word (a chunk of digits), size specified by WORD_SIZE.

    // Constructors
    public BigInteger(int size) {
        this.isNegative = false;
        this.values = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            this.values.add(0);
        }
    }

    public BigInteger() {
        this.isNegative = false;
        this.values = new ArrayList<Integer>();
    }

    // Getter for values
    public ArrayList<Integer> getValues() {
        return this.values;
    }

    // Setter for values at a specific index
    public void setValue(int value, int index) {
        if (index < this.values.size()) {
            this.values.set(index, value);
        } else {
            // Expand the list if index is out of bounds
            while (this.values.size() <= index) {
                this.values.add(0);
            }
            this.values.set(index, value);
        }
    }

    public void add(BigInteger num){
        int carry = 0;
        int idx_1 = this.values.size() - 1;
        int idx_2 = num.getValues().size() - 1;
        int maxSize = Math.max(this.values.size(), num.getValues().size());
        BigInteger tempBInt = new BigInteger(maxSize);

        int idx = maxSize - 1;

        // Performing the addition logic by iterating over the arrays.
        while (carry > 0 || idx_1 >= 0 || idx_2 >= 0) { // continue till we have carry or we are done iterating over both numbers
            int val1 = idx_1 >= 0 ? this.values.get(idx_1--) : 0;
            int val2 = idx_2 >= 0 ? num.getValues().get(idx_2--) : 0;
            int sum = val1 + val2 + carry;
            tempBInt.setValue(sum & ((1 << WORD_SIZE) - 1), idx); // store the resulting sum word
            carry = sum >>> WORD_SIZE;  // handle overflow by shifting carry into next operation
            idx--;
        }
        // If there is a carry left after processing all digits, adjust the values
        if (carry > 0) {
            tempBInt.values.add(0, carry);
        }
        this.values = tempBInt.getValues(); // update current object's digits with the addition result
    }
}