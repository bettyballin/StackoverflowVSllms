import java.lang.String;

public class ProjectsWithinOneMonthOfKickoffMeetingDate {
    // Placeholder classes to make the code executable
    static class Session {
        public Query createQuery(String s) {
            return new Query();
        }
    }

    static class Query {
    }

    // Instance of Session
    Session session = new Session();

    // Use session to create query
    Query query = session.createQuery("from com.ep.cqprojects.db.Projects " +
            "where months_between(active_date, kickoff_meeting_date) < 1");

    public static void main(String[] args) {
    }
}