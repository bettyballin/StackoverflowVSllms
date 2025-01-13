import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class SearchFormProcessor {
    private HttpServletRequest context;

    public SearchFormProcessor(HttpServletRequest context) {
        this.context = context;
    }

    public void processSearchForm() {
        SearchForm searchForm = (SearchForm) context.getAttribute("SearchForm");
        // Rest of the code...
    }

    public static void main(String[] args) {
        // This main method is just for compilation purposes.
        // The actual usage of SearchFormProcessor should be in a servlet context.
    }
}