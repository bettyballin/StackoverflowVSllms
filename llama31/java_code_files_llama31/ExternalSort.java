/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ExternalSort {
    public static void sort(String string, String string2) throws IOException {
        Object object;
        Object object2;
        Object object3;
        int n;
        int n2 = 100000;
        int n3 = (int)Math.ceil(1000000.0 / (double)n2);
        for (int i = 0; i < n3; ++i) {
            int n4 = i * n2;
            n = Math.min(n4 + n2, 1000000);
            object3 = new DataInputStream(new FileInputStream(string));
            ((DataInputStream)object3).skipBytes(n4 * 4);
            object2 = new int[n - n4];
            for (int j = 0; j < ((Object)object2).length; ++j) {
                object2[j] = ((DataInputStream)object3).readInt();
            }
            ((FilterInputStream)object3).close();
            Arrays.sort((int[])object2);
            object = "chunk" + i + ".dat";
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream((String)object));
            for (int j = 0; j < ((Object)object2).length; ++j) {
                dataOutputStream.writeInt((int)object2[j]);
            }
            dataOutputStream.close();
        }
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(string2));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (n = 0; n < n3; ++n) {
            object3 = "chunk" + n + ".dat";
            object2 = new DataInputStream(new FileInputStream((String)object3));
            priorityQueue.add(((DataInputStream)object2).readInt());
            ((FilterInputStream)object2).close();
        }
        while (!priorityQueue.isEmpty()) {
            n = (Integer)priorityQueue.poll();
            dataOutputStream.writeInt(n);
            for (int i = 0; i < n3; ++i) {
                object2 = "chunk" + i + ".dat";
                object = new DataInputStream(new FileInputStream((String)object2));
                int n5 = ((DataInputStream)object).readInt();
                if (n5 < n) {
                    priorityQueue.add(n5);
                }
                ((FilterInputStream)object).close();
            }
        }
        dataOutputStream.close();
    }

    public static void main(String[] stringArray) throws IOException {
        String string = "input.dat";
        String string2 = "output.dat";
        ExternalSort.sort(string, string2);
    }
}
