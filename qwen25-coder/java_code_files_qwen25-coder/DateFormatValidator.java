import java.lang.String;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatValidator extends FieldValidatorSupport {

    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void validate(Object object) throws ValidationException {
        final String fieldName = getFieldName();
        final String value = (String) getFieldValue(fieldName, object);

        if (value != null && !value.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false); // strict parsing

            try {
                dateFormat.parse(value);
            } catch (ParseException e) {
                addFieldError(fieldName, object);
            }
        }
    }

    public static void main(String[] args) {
    }
}