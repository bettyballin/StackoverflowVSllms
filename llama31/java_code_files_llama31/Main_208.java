/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.LinkedBlockingQueue;

public class Main_208 {
    public static void main(String[] stringArray) {
        LinkedBlockingQueue<CompletedTask> linkedBlockingQueue = new LinkedBlockingQueue<CompletedTask>();
        Object object = new Object();
        CompletedTask completedTask = new CompletedTask(object);
        linkedBlockingQueue.add(completedTask);
    }
}
