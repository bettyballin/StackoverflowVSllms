/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.ejb.Stateful
 */
import javax.ejb.Stateful;

@Stateful
public class MyStatefulBean {
    private int counter;

    public synchronized void incrementCounter() {
        ++this.counter;
    }

    public synchronized int getCounter() {
        return this.counter;
    }

    public static void main(String[] stringArray) {
        MyStatefulBean myStatefulBean = new MyStatefulBean();
        myStatefulBean.incrementCounter();
        int n = myStatefulBean.getCounter();
        System.out.println("Current counter value: " + n);
    }
}
