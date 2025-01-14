import java.lang.String;

public abstract class AbstractRequest {}

public abstract class AbstractResponse {}

public class SMSRequest extends AbstractRequest {}
public class EmailRequest extends AbstractRequest {}

public class SMSResponse extends AbstractResponse {}
public class EmailResponse extends AbstractResponse {
    public static void main(String[] args) {
    }
}