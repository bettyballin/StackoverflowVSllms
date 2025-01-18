import java.util.List;
import com.atlassian.jira.rpc.soap.client.RemoteIssue;
import com.atlassian.jira.rpc.soap.client.RemoteProject;
import com.atlassian.jira.rpc.soap.client.SearchParams;
import com.atlassian.jira.rpc.soap.client.JiraSoapService;

public class JiraSoapClient {
    SearchParams sp;
    RemoteProject rp;
    List<RemoteIssue> issueResultList;
    String PROJECT_ID = "12345"; // replace "12345" with your project ID
    JiraSoapService _soapService;

    public JiraSoapClient() {
        sp = new SearchParams(); // create new object SearchParams
        sp.setVersionId("12345"); // replace "12345" with your version id
        rp = new RemoteProject(PROJECT_ID); // replace PROJECT_ID with the desired JIRA project ID
        issueResultList = _soapService.getIssuesFromTextSearchWithProject("api-token", "user@domain.com", rp, sp);
    }

    public static void main(String[] args) {
    }
}