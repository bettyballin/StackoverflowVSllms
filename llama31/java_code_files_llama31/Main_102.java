/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.locks.ReentrantLock;

public class Main_102 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Alg[] algArray = new Alg[10];
        ExecPanel[] execPanelArray = new ExecPanel[10];
        for (int i = 0; i < 10; ++i) {
            algArray[i] = new Alg();
            execPanelArray[i] = new ExecPanel();
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        while (true) {
            reentrantLock.lock();
            try {
                for (int i = 0; i < algArray.length; ++i) {
                    if (!execPanelArray[i].isReset()) continue;
                    algArray[i].terminate();
                    Main_102.createProgram(i);
                    algArray[i].start();
                    execPanelArray[i].unreset();
                }
            }
            finally {
                reentrantLock.unlock();
            }
            try {
                Thread.sleep(100L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                continue;
            }
            break;
        }
    }

    public static void createProgram(int n) {
        System.out.println("Creating program for index " + n);
    }
}
