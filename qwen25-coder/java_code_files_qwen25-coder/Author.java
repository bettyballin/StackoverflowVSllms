import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Test code can be added here
    }
}

class Author {
    private int id;
    private String name;
    private List<Book> books; // one-to-many relationship

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}

class Book {
    private int id;
    private String title;
    private List<Author> authors; // many-to-many relationship

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.authors = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public String getTitle() {
        return title;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors.stream().map(Author::getName).toArray() +
                '}';
    }
}

class DataMapper {

    private final Connection connection;

    public DataMapper(Connection connection) {
        this.connection = connection;
    }

    public List<Author> getAuthorsWithBooks() throws SQLException {
        String query = "SELECT a.id AS author_id, a.name AS author_name, b.id AS book_id, b.title FROM authors a LEFT JOIN book_authors ba ON a.id = ba.author_id LEFT JOIN books b ON ba.book_id = b.id";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            Map<Integer, Author> authorsMap = new HashMap<>();
            while (rs.next()) {
                int authorId = rs.getInt("author_id");
                String authorName = rs.getString("author_name");
                int bookId = rs.getInt("book_id");
                String bookTitle = rs.getString("title");

                Author author = authorsMap.get(authorId);
                if (author == null) {
                    author = new Author(authorId, authorName);
                    authorsMap.put(authorId, author);
                }

                if (bookId != 0 && bookTitle != null) { // assuming NULL means no book
                    Book book = getBookById(bookId); // assuming this method is implemented to fetch book details
                    author.addBook(book);
                }
            }
            return new ArrayList<>(authorsMap.values());
        }
    }

    public List<Book> getBooksWithAuthors() throws SQLException {
        String query = "SELECT b.id AS book_id, b.title, a.id AS author_id, a.name FROM books b LEFT JOIN book_authors ba ON b.id = ba.book_id LEFT JOIN authors a ON ba.author_id = a.id";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            Map<Integer, Book> booksMap = new HashMap<>();
            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                String bookTitle = rs.getString("title");
                int authorId = rs.getInt("author_id");
                String authorName = rs.getString("name");

                Book book = booksMap.get(bookId);
                if (book == null) {
                    book = new Book(bookId, bookTitle);
                    booksMap.put(bookId, book);
                }

                if (authorId != 0 && authorName != null) { // assuming NULL means no author
                    Author author = getAuthorById(authorId); // assuming this method is implemented to fetch author details
                    book.addAuthor(author);
                }
            }
            return new ArrayList<>(booksMap.values());
        }
    }

    private Author getAuthorById(int id) throws SQLException {
        String query = "SELECT id, name FROM authors WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Author(rs.getInt("id"), rs.getString("name"));
            }
        }
        return null;
    }

    private Book getBookById(int id) throws SQLException {
        String query = "SELECT id, title FROM books WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt("id"), rs.getString("title"));
            }
        }
        return null;
    }
}