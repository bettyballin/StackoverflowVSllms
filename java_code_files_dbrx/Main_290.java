import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String src = "input.txt";
        String tgt = "output.txt";
        Buffer buffer = new Buffer();

        Thread readThread = new Thread() {
            public void run() {
                try {
                    InputStream fileIn = new FileInputStream(src);
                    int byteRead;
                    while ((byteRead = fileIn.read()) != -1) {
                        buffer.put(byteRead);
                    }
                    buffer.signal();
                    fileIn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread writeThread = new Thread() {
            public void run() {
                try {
                    buffer.await();
                    OutputStream fileOut = new FileOutputStream(tgt);
                    while (!buffer.isEmpty()) {
                        int byteWrite = buffer.get();
                        fileOut.write(byteWrite);
                    }
                    fileOut.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        readThread.start();
        writeThread.start();
    }
}

class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    private boolean isSignaled = false;

    public synchronized void put(int b) {
        queue.offer(b);
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (queue.isEmpty() && !isSignaled) {
            wait();
        }
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized void signal() {
        isSignaled = true;
        notifyAll();
    }

    public synchronized void await() throws InterruptedException {
        while (!isSignaled) {
            wait();
        }
    }
}