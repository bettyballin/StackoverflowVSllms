import java.io.*;
import java.nio.file.*;

public class InsertViruses {

    public static void insertViruses(FileLocation[] locations, byte[][] viruses, String logpath) {
        try {
            FileOutputStream logwriter = new FileOutputStream(logpath, true);

            for (int i = 0; i < locations.length; i++) {
                // Prep to copy section
                int locationOfChange = locations[i].index;
                String filepathToChange = locations[i].filepath;
                File checkIfBackupExists = new File(filepathToChange + ".bak");
                if (!checkIfBackupExists.exists()) {
                    Files.copy(new File(filepathToChange).toPath(), new File(filepathToChange + ".bak").toPath());
                }
                Files.copy(new File(filepathToChange).toPath(), new File(filepathToChange + ".tmp").toPath());

                // Read section into byte array to write in log
                RandomAccessFile x = new RandomAccessFile(filepathToChange, "rw");
                x.seek(locationOfChange);
                byte[] removedSection = new byte[viruses[i].length];
                x.readFully(removedSection);
                x.close();

                // Write changes to log
                String hexRemovedSection = bytesToHex(removedSection);
                String hexVirus = bytesToHex(viruses[i]);
                int hashValue = new String(viruses[i]).hashCode();
                String hexHash = Integer.toHexString(hashValue);

                logwriter.write(String.format("insert into changes (filepath,loc,dat,vir,hash) values ('%s',%d,X'%s',X'%s',X'%s');\n",
                        filepathToChange, locationOfChange, hexRemovedSection, hexVirus, hexHash).getBytes());

                // Insert virus into file
                RandomAccessFile fileToInsertIn = new RandomAccessFile(filepathToChange + ".tmp", "rw");
                fileToInsertIn.seek(locationOfChange);
                fileToInsertIn.write(viruses[i]);
                fileToInsertIn.close();

                Files.move(new File(filepathToChange + ".tmp").toPath(), new File(filepathToChange).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            logwriter.close();
        } catch (Exception e) {
            System.err.println(e.toString());
            System.err.println("Error: InsertVirusesIntoCorpus, line 100");
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

class FileLocation {
    public int index;
    public String filepath;

    public FileLocation(int index, String filepath) {
        this.index = index;
        this.filepath = filepath;
    }
}