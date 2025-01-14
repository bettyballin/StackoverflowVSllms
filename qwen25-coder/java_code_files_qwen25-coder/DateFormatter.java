import javax.faces.bean.ManagedBean;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "dateFormatter")
public class DateFormatter {
    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}

class Main {
    public static void main(String[] args) {
    }
}