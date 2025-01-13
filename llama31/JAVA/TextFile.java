import java.util.List;
import java.util.ArrayList;

interface File {
  void print();
}

class TextFile implements File {
  private String name;

  public TextFile(String name) {
    this.name = name;
  }

  @Override
  public void print() {
    System.out.println(name);
  }
}

class Folder implements File {
  private List<File> files = new ArrayList<>();

  public void add(File file) {
    files.add(file);
  }

  @Override
  public void print() {
    for (File file : files) {
      file.print();
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Folder folder = new Folder();
    folder.add(new TextFile("file1.txt"));
    folder.add(new TextFile("file2.txt"));
    folder.print();
  }
}