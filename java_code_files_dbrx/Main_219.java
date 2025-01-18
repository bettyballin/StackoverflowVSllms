public class Main {
    public static void main(String[] args) {
        String longRunningQueryAsString = ""; // Initialize your long-running query here

        String createJobSQL =
          "BEGIN\n" +
            "DBMS_SCHEDULER.CREATE_JOB (\n" +
              "job_name        => 'my_long_running_query',\n" +
              "job_type        => 'PLSQL_BLOCK',\n" +
              "job_action      => '" + "\n" + longRunningQueryAsString + "',\n" +
            ");\n" +
          "END;\n";

        String executeJobSQL =
          "BEGIN\n" +
            "DBMS_SCHEDULER.RUN_JOB (\n" +
              "job_name        => 'my_long_running_query'\n"+
             ");\n" +
           "END;\n";

        String dropJobSQL =
          "BEGIN\n" +
            "DBMS_SCHEDULER.DROP_JOB (\n" +
              "job_name        => 'my_long_running_query'\n"+
             ");\n" +
           "END;\n";
    }
}