import java.util.Iterator;
import java.util.List;

public class ConsultantSearchResultIteratorProvider {
    // Assuming userSearch is an object of some class with getConsultantMatches method
    // and searchstring is a variable holding the search string
    public Iterator<CgConsultant> getSearchresult() {
        List<CgConsultant> list = userSearch.getConsultantMatches(searchstring);
        return list.iterator();
    }

    public static void main(String[] args) {
        // This main method is empty and doesn't do anything
    }
}