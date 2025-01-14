import java.util.List;
import java.util.ArrayList;

public class ObjectPoolTest {

    List<A> list = new ArrayList<>();
    String[] test = {"ram", "mohan", "anil", "mukesh", "mittal"};
    ObjectPool<A> pool = new ObjectPool<>(() -> new A());

    public ObjectPoolTest() {
        for (int i = 0; i < test.length; i++) {
            A a = pool.acquire();
            a.setName(test[i]);
            list.add(a);
        }

        // After processing, you can release objects back to the pool
        for (A item : list) {
            pool.release(item);
        }
    }

    public static void main(String[] args) {
        new ObjectPoolTest();
    }
}

class A {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}

class ObjectPool<T> {
    private java.util.function.Supplier<T> creator;
    private List<T> pool = new ArrayList<>();

    public ObjectPool(java.util.function.Supplier<T> creator) {
        this.creator = creator;
    }

    public T acquire() {
        if (pool.isEmpty()) {
            return creator.get();
        } else {
            return pool.remove(pool.size() - 1);
        }
    }

    public void release(T obj) {
        pool.add(obj);
    }
}