import org.hibernate.EmptyInterceptor;
import org.hibernate.event.PostLoadEvent;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

public class MyInterceptor extends EmptyInterceptor {
    public void onPostLoad(final PostLoadEvent event) {
        // Do what you want on post-load.
    }

    public static void main(String[] args) {
        // set up your Hibernate sessionFactory to use the interceptor
        LocalSessionFactoryBean sb = new LocalSessionFactoryBean();
        sb.getHibernateProperties().setProperty("hibernate.jdbc.batch_size", "0");
        sb.setEntityInterceptor(new MyInterceptor());
    }
}