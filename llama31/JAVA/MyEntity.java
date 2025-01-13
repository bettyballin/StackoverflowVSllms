import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Formula;

@Entity
public class MyEntity {
  
  @Column(name = "word")
  private String word;

  @Formula("NORMALIZE(word, NFD)")
  private String normalizedWord;
  
  // getters and setters

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getNormalizedWord() {
    return normalizedWord;
  }

  public void setNormalizedWord(String normalizedWord) {
    this.normalizedWord = normalizedWord;
  }

  public static void main(String[] args) {
  }
}