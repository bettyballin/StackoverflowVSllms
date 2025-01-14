import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CustomerService_1 {

    private SessionFactory sessionFactory = new SessionFactory();

    public List<CustomerDTO> getCustomersWithArticles() {
        Session session = sessionFactory.openSession();
        try {
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
            List<Customer> customers = query.list();

            List<CustomerDTO> customerDTOs = new ArrayList<>();
            for (Customer customer : customers) {
                Hibernate.initialize(customer.getArticles()); // Ensure lazy-loaded collection is initialized
                customerDTOs.add(new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getArticles().stream()
                        .map(article -> new ArticleDTO(article.getId(), article.getDescription()))
                        .collect(Collectors.toList())
                ));
            }
            return customerDTOs;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
    }
}

// Supporting classes to make the code executable

class SessionFactory {
    public Session openSession() {
        return new Session();
    }
}

class Session {
    public void close() {
    }

    public <T> Query<T> createQuery(String queryString, Class<T> clazz) {
        return new Query<>();
    }
}

class Query<T> {
    public List<T> list() {
        return new ArrayList<>();
    }
}

class Hibernate {
    public static void initialize(Object proxy) {
    }
}

class Customer {
    public int getId() {
        return 0;
    }

    public String getName() {
        return "";
    }

    public List<Article> getArticles() {
        return new ArrayList<>();
    }
}

class CustomerDTO {
    public CustomerDTO(int id, String name, List<ArticleDTO> articles) {
        // Constructor implementation
    }
}

class Article {
    public int getId() {
        return 0;
    }

    public String getDescription() {
        return "";
    }
}

class ArticleDTO {
    public ArticleDTO(int id, String description) {
        // Constructor implementation
    }
}