/*
 * Decompiled with CFR 0.152.
 */
public class JiraIssueFetcher {
    private String projectName;
    private String versionName;
    private Object _soapService;

    public JiraIssueFetcher(String string, String string2, Object object) {
        this.projectName = string;
        this.versionName = string2;
        this._soapService = object;
    }

    public void fetchIssues() {
        String string = "project = '" + this.projectName + "' AND fixVersion = '" + this.versionName + "'";
        RemoteIssue[] remoteIssueArray = ((SoapService)this._soapService).getIssuesFromJql(string, 100);
    }

    public static void main(String[] stringArray) {
    }
}
