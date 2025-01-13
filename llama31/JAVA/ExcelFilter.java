import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = ".*\\.xls$", dispatcherTypes = DispatcherType.REQUEST)
public class ExcelFilter implements Filter {
    // ...

    public static void main(String[] args) {
    }
}