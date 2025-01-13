import java.lang.Integer;
import java.lang.String;

public class BranchBuildingCleanupService {

    public static void main(String[] args) {
        // Assuming allBranchBuilding and branchBuildingDao are defined somewhere
        // and sess is a valid Hibernate session
        for (Integer integer : allBranchBuilding) {
            branchBuildingDao.delete(integer, sess);
            sess.flush(); // force Hibernate to synchronize with the database
        }
    }
}