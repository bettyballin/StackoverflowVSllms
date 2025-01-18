import java.util.List;

public class ConsultantSearchResultsManager {

    public List<CgConsultant> getSearchResults() {
        List<CgConsultant> list = userSearch.getConsultantMatches(seaRCString);
        System.out.println("The size of the result list:" + list.size());
        return list;
    }

    private UserSearch userSearch;
    private String seaRCString;

    public static void main(String[] args) {
    }
}

class UserSearch {
    public List<CgConsultant> getConsultantMatches(String seaRCString) {
        return null;  // Stub method
    }
}

class CgConsultant {
    // Stub class
}