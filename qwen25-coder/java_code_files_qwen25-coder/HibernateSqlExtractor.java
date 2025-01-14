import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.loader.criteria.CriteriaLoader;
import org.hibernate.loader.criteria.CriteriaQueryTranslator;
import org.hibernate.persister.entity.OuterJoinLoadable;
import org.hibernate.engine.spi.LoadQueryInfluencers;

public class HibernateSqlExtractor {

    public static String getGeneratedSql(Criteria criteria, SharedSessionContractImplementor session) {
        CriteriaImpl criteriaImpl = (CriteriaImpl) criteria;
        SessionFactoryImplementor factory = (SessionFactoryImplementor) session.getSessionFactory();

        CriteriaQueryTranslator translator =
                new CriteriaQueryTranslator(
                        factory,
                        criteriaImpl,
                        criteriaImpl.getEntityOrClassName(),
                        CriteriaQueryTranslator.ROOT_SQL_ALIAS);

        String[] implementors = factory.getImplementors(criteriaImpl.getEntityOrClassName());
        OuterJoinLoadable persister = (OuterJoinLoadable) factory.getEntityPersister(implementors[0]);
        LoadQueryInfluencers loadQueryInfluencers = session.getLoadQueryInfluencers();

        CriteriaLoader loader = new CriteriaLoader(
                persister,
                factory,
                translator,
                criteriaImpl,
                loadQueryInfluencers
        );

        String sql = loader.getSQLString();

        return sql;
    }

    public static void main(String[] args) {
        // Assuming you have a Session instance
        Session session = null; // Placeholder for compilation
        Criteria criteria = session.createCriteria(Operator.class);

        // Build up your criteria...

        String sql = getGeneratedSql(criteria, (SharedSessionContractImplementor) session);
        System.out.println("Generated SQL:\n" + sql);
    }
}

// Placeholder Operator class
class Operator {
    // Define fields and methods as needed
}