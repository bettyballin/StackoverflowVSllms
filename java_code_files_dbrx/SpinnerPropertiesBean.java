import java.lang.String;
public class SpinnerPropertiesBean {
    //...
    private int value;
    private boolean readOnlyInput = true;
    private boolean disableSpinner = false; // default to not disabled

    public void onReadonlyInputChange() {
        if (readOnlyInput) {
            this.disableSpinner = true;
        } else {
            this.disableSpinner = false;
        }
    }
    // getters and setters
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public boolean isReadOnlyInput() {
        return readOnlyInput;
    }
    public void setReadOnlyInput(boolean readOnlyInput) {
        this.readOnlyInput = readOnlyInput;
    }
    public boolean isDisableSpinner() {
        return disableSpinner;
    }
    public void setDisableSpinner(boolean disableSpinner) {
        this.disableSpinner = disableSpinner;
    }
    public static void main(String[] args) {
    }
}