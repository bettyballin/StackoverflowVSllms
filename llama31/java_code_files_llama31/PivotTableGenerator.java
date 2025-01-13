/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PivotTableGenerator {
    public static void main(String[] stringArray) throws IOException {
        File file = new File("pivot_table_script.vbs");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("your_vbs_script_here");
        fileWriter.close();
        Runtime.getRuntime().exec("wscript " + file.getAbsolutePath());
    }
}
