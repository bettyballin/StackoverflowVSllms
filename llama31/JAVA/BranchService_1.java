import java.lang.String;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class BranchService_1_1 {

    private SessionFactory sessionFactory;
    private HumanDao humanDao;
    private BranchDao branchDao;

    public void changeBranch(Branch branch) throws DatabaseException {
        TransactionTemplate template = new TransactionTemplate(sessionFactory);
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                //some code
                humanDao.update(he);
                //some code
                branchDao.update(be);
                //some code
            }
        });
    }

    public static void main(String[] args) {
    }
}