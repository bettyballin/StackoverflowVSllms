import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Server_1 implements BookDB {
    private Map<String, String> books = new HashMap<>();

    public String getTitle(int id) throws Exception {
        if (id < 0 || id > books.size()) throw new Exception("Invalid Id!");
        return books.get("title#" + id);
    }

    public boolean addBook(String title, int id) throws Exception{
      //Add a book to the database...
      if (books.containsKey("title#" + id)) throw new Exception("Id already taken.");
      books.put("title#" + id, title);
      return true;
    }

    public static void main(String[] args) {
    }
}

interface BookDB {
    String getTitle(int id) throws Exception;
    boolean addBook(String title, int id) throws Exception;
}