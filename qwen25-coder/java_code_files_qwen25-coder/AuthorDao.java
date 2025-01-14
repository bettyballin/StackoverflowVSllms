import java.util.List;

public class AuthorDao {
    // Using JPQL with a fetch join
    List<Author> authors;

    public static void main(String[] args) {
        AuthorDao dao = new AuthorDao();
        dao.fetchAuthors();
    }

    public void fetchAuthors() {
        Session session = new Session();
        authors = session.createQuery("FROM Author A JOIN FETCH A.books", Author.class).list();
    }
}

// Minimal Session class stub
class Session {
    public <T> Query<T> createQuery(String query, Class<T> clazz) {
        return new Query<>();
    }
}

// Minimal Query class stub
class Query<T> {
    public List<T> list() {
        return null;
    }
}

// Minimal Author class stub
class Author {
    List<Book> books;
}

// Minimal Book class stub
class Book {
    // Book details
}