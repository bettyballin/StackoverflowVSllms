import java.lang.Runtime;
import java.lang.String;

public class DatabaseBackupUtil {
    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().exec("mysqldump -u username -p password mydatabase > backupfile.sql");
    }
}