/*
 * Decompiled with CFR 0.152.
 */
public class DatabaseBackupUtil {
    public static void main(String[] stringArray) throws Exception {
        Runtime.getRuntime().exec("mysqldump -u username -p password mydatabase > backupfile.sql");
    }
}
