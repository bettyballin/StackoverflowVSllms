import java.lang.String;
// Action class code
public class myAction {
    private Boolean optionA;
    private Boolean optionB;

    private static final String SUCCESS = "success";

    public String execute() throws Exception {
        // This makes radio for "optionA" to be auto checked.
        this.setOptionA(true);
        return SUCCESS;
    }
    
    public void setOptionA(Boolean value) {
        this.optionA = value;
    }

	public static void main(String[] args) {
	}
}