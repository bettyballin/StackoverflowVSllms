import java.util.List;

public class N1QueryProblem {
    public static void main(String[] args) {
        // Initial Query to fetch all Authors
        Session session = new Session();
        List<Author> authors = session.createQuery("FROM Author", Author.class).list();

        // For each author, another query is issued to fetch books
        for (Author author : authors) {
            // This will cause an additional query for each author
            List<Book> books = author.getBooks();
        }
    }
}

class Session {
    public <T> Query<T> createQuery(String query, Class<T> type) {
        return new Query<T>();
    }
}

class Query<T> {
    public List<T> list() {
        return null;
    }
}

class Author {
    public List<Book> getBooks() {
        return null;
    }
}

class Book {
}