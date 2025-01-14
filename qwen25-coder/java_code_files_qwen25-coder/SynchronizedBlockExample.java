import java.lang.String;

public class SynchronizedBlockExample {
    private final Object syncObject = new Object();

    int f;
    int[] ary;
    boolean someCondition;
    int someValue;

    void bar() {
        synchronized(syncObject) {
            f++;
            for (int i = 0; i < ary.length; i++) {
                if (someCondition) {
                    ary[i] += someValue;
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}