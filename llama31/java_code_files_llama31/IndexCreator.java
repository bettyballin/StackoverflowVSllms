/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class IndexCreator {
    public static void main(String[] stringArray) throws IOException {
        File file = new File("example.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");){
            Object object;
            Object object2;
            String string;
            HashMap<Object, Long> hashMap = new HashMap<Object, Long>();
            long l = 0L;
            while ((string = randomAccessFile.readLine()) != null) {
                object2 = string.split(",");
                object = object2[0].trim();
                hashMap.put(object, l);
                l = randomAccessFile.getFilePointer();
            }
            object2 = new File("index.txt");
            object = new FileWriter((File)object2);
            try {
                for (Map.Entry entry : hashMap.entrySet()) {
                    ((Writer)object).write((String)entry.getKey() + " " + Long.toHexString((Long)entry.getValue()) + "\n");
                }
            }
            finally {
                ((OutputStreamWriter)object).close();
            }
        }
    }
}
