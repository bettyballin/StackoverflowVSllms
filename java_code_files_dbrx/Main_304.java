import java.util.*;

class MyComparator implements Comparator<MyObject> {
  public int compare(MyObject a, MyObject b) {
    // Custom comparison logic here...
    return 0;
  }
}

class MyObject {
  // Some fields and methods...
}

public class Main {
  public static void main(String[] args) {
    List<MyObject> list = new ArrayList<>();
    // Populate the list with objects...
    list.add(new MyObject());
    list.add(new MyObject());
    Collections.sort(list, new MyComparator());
  }
}