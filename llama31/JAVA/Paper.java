import java.lang.String;

public class Paper {
  private String content;

  public Paper(String content) {
    this.content = content;
  }

  public Paper clone() {
    return new Paper(content);
  }

  public static void main(String[] args) {
    Paper original = new Paper("Hello World!");
    Paper copy = original.clone();
  }
}