import java.util.Map;
import java.util.HashMap;

public class Book_1 {
  private String title;
  private String author;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }
}

public class Book_1Factory {
  private Map<String, Book> books = new HashMap<>();

  public Book getBook(String title, String author) {
    if (!books.containsKey(title)) {
      books.put(title, new Book(title, author));
    }
    return books.get(title);
  }

  public static void main(String[] args) {
    BookFactory factory = new BookFactory();
    Book book1 = factory.getBook("Harry Potter", "J.K. Rowling");
    Book book2 = factory.getBook("Harry Potter", "J.K. Rowling");
  }
}