import java.lang.String;

public class Report {
    public boolean isSubReportOf(Report other) {
        // complex logic to determine if this report is a sub-report of the other
        return false; // temporary implementation to make the code compile
    }
}

public class ReportProcessor {
    public void processReports(Report a, Report b) {
        if (a.isSubReportOf(b) || b.isSubReportOf(a)) {
            // do stuff
        }
    }

    public static void main(String[] args) {
        ReportProcessor processor = new ReportProcessor();
        Report reportA = new Report();
        Report reportB = new Report();
        processor.processReports(reportA, reportB);
    }
}