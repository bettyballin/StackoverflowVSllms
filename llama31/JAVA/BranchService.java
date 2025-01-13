import java.lang.String;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

public class BranchService {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeBranch(Branch branch) throws DatabaseException {
        //some code
        humanDao.update(he);
        //some code
        branchDao.update(be);
        //some code
    }

    public static void main(String[] args) {
    }
}