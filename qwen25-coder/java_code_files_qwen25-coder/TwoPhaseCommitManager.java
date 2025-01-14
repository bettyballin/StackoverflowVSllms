import java.lang.String;
public class TwoPhaseCommitManager {

    private DatabaseConnection dbA;
    private DatabaseConnection dbB;

    public void executeTransaction() {
        // Prepare phase
        String id = null;
        boolean canAllCommit = true;

        try {
            dbA.startTransaction();
            dbA.insertDataStage1(); // Insert data in Application A
            dbA.prepareToCommit();   // Mark transaction as ready to commit

            dbB.startTransaction();
            id = dbB.insertDataStage2(); // Call Application B and get ID
            dbB.prepareToCommit();       // Mark transaction as ready to commit
        } catch (Exception e) {
            canAllCommit = false;
        }

        // Commit phase
        if (canAllCommit) {
            try {
                dbA.commitTransaction();
                dbB.insertRelatedData(id); // Use ID from B for further insert in A
                dbB.commitTransaction();
            } catch (Exception e) {
                // Rollback both transactions if any commit fails
                rollbackAndHandleError();
            }
        } else {
            rollbackAndHandleError();
        }
    }

    private void rollbackAndHandleError() {
        try {
            if (dbA.isInTransaction()) {
                dbA.rollbackTransaction();
            }
        } catch (Exception e) {
            // Log or handle exception
        }
        try {
            if (dbB.isInTransaction()) {
                dbB.rollbackTransaction();
            }
        } catch (Exception e) {
            // Log or handle exception
        }
    }

    // Assume DatabaseConnection has methods for transaction management.

    public static void main(String[] args) {
    }
}

class DatabaseConnection {

    public void startTransaction() {
        // Implement transaction start logic
    }

    public void insertDataStage1() {
        // Implement data insertion logic for stage 1
    }

    public void prepareToCommit() {
        // Implement prepare to commit logic
    }

    public String insertDataStage2() {
        // Implement data insertion logic for stage 2 and return ID
        return "some_id";
    }

    public void commitTransaction() {
        // Implement commit transaction logic
    }

    public boolean isInTransaction() {
        // Return transaction status
        return true;
    }

    public void rollbackTransaction() {
        // Implement rollback logic
    }

    public void insertRelatedData(String id) {
        // Implement related data insertion logic using id
    }
}