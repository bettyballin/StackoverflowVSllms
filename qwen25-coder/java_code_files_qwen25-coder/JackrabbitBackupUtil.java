import java.lang.String;
import org.apache.jackrabbit.core.util.db.ConnectionHelper;
import org.apache.jackrabbit.standalone.cli.CommandException;
import org.apache.jackrabbit.standalone.cli.BackupTool;

public class JackrabbitBackupUtil {
    public static void main(String[] args) throws CommandException {
        String repoUri = "jndi:/repository";
        String backupDir = "/path/to/backup/directory";

        // Assuming you have setup the command environment
        BackupTool.backupRepository(repoUri, backupDir);
    }
}