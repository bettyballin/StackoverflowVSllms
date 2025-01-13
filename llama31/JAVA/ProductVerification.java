import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.http.HttpServletRequest;

public class ProductVerification extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;
    private SessionFactory sessionFactory;

    // You need to implement the setServletRequest method from ServletRequestAware
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    // You will need to adjust this to fit your actual database and Hibernate configuration
    public Session getHibernateSession() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

    @Override
    public void prepare() throws Exception {
        Session session = this.getHibernateSession();
        Transaction tx = session.beginTransaction();
        // Assuming setCountryListCombo is defined somewhere in your class
        this.setCountryListCombo();
        tx.commit();
        session.close(); // Close the session after use
    }

    @Override
    public void validate() {
        if (request.getParameter("countryId") == null || request.getParameter("countryId").equals("0")) {
            addFieldError("countryId", "Please select country");
        }
    }

    @Override
    public String execute() throws Exception {
        // Your logic here
        return SUCCESS;
    }

    // Example method, you need to implement the logic to set the country list combo
    public void setCountryListCombo() {
        // Your logic here
    }

    public static void main(String[] args) {
        // Typically, you wouldn't run a Struts 2 action from the main method.
        // This is here just to meet the executable requirement.
        new ProductVerification();
    }
}