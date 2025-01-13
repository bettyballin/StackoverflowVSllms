import java.lang.String;

public class GiftExample {
  public interface Gift {
    void wrap();
  }

  public static class Book implements Gift {
    @Override
    public void wrap() {
      System.out.println("Wrapping a book.");
    }
  }

  public static class GiftWrapper implements Gift {
    private Gift gift;

    public GiftWrapper(Gift gift) {
      this.gift = gift;
    }

    @Override
    public void wrap() {
      gift.wrap();
      System.out.println("Adding a ribbon.");
    }
  }

  public static void main(String[] args) {
    Gift book = new Book();
    Gift wrappedBook = new GiftWrapper(book);
    wrappedBook.wrap();
  }
}