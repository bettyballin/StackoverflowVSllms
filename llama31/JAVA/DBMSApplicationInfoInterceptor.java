import org.jboss.aop.advice.Interceptor;
import org.jboss.aop.joinpoint.Invocation;
import org.jboss.tm.TransactionManager;
import org.jboss.tm.TransactionManagerInterceptor;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;

public class DBMSApplicationInfoInterceptor implements Interceptor {
    @Override
    public String getName() {
        return "DBMSApplicationInfoInterceptor";
    }

    @Override
    public Object invoke(Invocation invocation) throws Throwable {
        TransactionManager tm = (TransactionManager) invocation.getAdvisor().getMetaData().getAspect(TransactionManagerInterceptor.class);
        OracleConnection connection = (OracleConnection) tm.getTransaction().getResource(OracleConnection.class);

        if (connection != null) {
            OracleCallableStatement cs = connection.prepareCall("BEGIN DBMS_APPLICATION_INFO.SET_MODULE(:1, :2); END;");
            cs.setString(1, "Your Application Name");
            cs.setString(2, "Your Action Name");
            cs.execute();
            cs.close();
        }

        return invocation.invokeNext();
    }

    public static void main(String[] args) {
        // You need a main method to make the class executable
    }
}