import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class DateFormatValidator extends FieldValidatorSupport {

    private String format;

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void validate(Object object) throws ValidationException {
        String date = (String) getFieldValue(getFieldName(), object);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);

        try {
            sdf.parse(date);
        } catch (ParseException e) {
            addActionError(getDefaultMessage());
        }
    }

    public static void main(String[] args) {
        // Add this line to test the validator
        System.out.println("DateFormatValidator class is compiled and running.");
    }
}