import java.util.logging.*;

public class FormattableFilter extends Formatter {
    
    private SimpleFormatter delegate = new SimpleFormatter();

    @Override
    public String format(LogRecord record) {
        if (record.getMessage().contains("WARNING")) return null; // Swallow the warning
        else return delegate.format(record);
    }

    public static void main(String[] args) {
    }
}