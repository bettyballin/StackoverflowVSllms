import java.lang.String;
public class CustomException extends Exception{
    public CustomException(String message){
        super(message); //calling parent constructor to construct the exception object.
        /* Any additional custom operations goes here */
    }

	public static void main(String[] args) {
	}
}