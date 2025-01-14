import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = Collections.synchronizedList(new ArrayList<Account>());
    }
}

class Account {
    // Account class implementation (empty)
}