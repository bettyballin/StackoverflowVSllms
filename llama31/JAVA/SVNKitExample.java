import java.io.File;
import java.util.Collection;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
import org.tmatesoft.svn.core.wc2.SvnLog;
import org.tmatesoft.svn.core.wc2.SvnLogEntry;

public class SVNKitExample {
    public static void main(String[] args) throws SVNException {
        SVNURL url = SVNURL.fromFile(new File("/path/to/repo"));
        SVNRepository repository = SVNRepositoryFactory.create(url);
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager("username", "password");
        repository.setAuthenticationManager(authManager);

        SVNClientManager clientManager = SVNClientManager.newInstance(null, authManager);
        SVNRevision revision = new SVNRevision(12345); // Example revision

        // Fetch the log entries
        Collection<SVNLogEntry> logEntries = clientManager.getLogClient().doLog(url, revision, revision, true, true);

        // Process log entries
        for (SVNLogEntry logEntry : logEntries) {
            System.out.println(logEntry.getMessage());
        }
    }
}