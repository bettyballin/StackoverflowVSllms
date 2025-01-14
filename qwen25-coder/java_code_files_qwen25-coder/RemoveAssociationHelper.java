import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class RemoveAssociationHelper {
    // On removing B from A's side, also remove A from B's side.

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Session session = new Session();
        Transaction transaction = new Transaction();

        a.getBs().remove(b);
        b.getAs().remove(a);

        session.flush();
        transaction.commit();
    }
}

class A {
    private List<B> bs = new ArrayList<>();

    public List<B> getBs() {
        return bs;
    }
}

class B {
    private List<A> as = new ArrayList<>();

    public List<A> getAs() {
        return as;
    }
}

class Session {
    public void flush() {
        System.out.println("Session flushed");
    }
}

class Transaction {
    public void commit() {
        System.out.println("Transaction committed");
    }
}