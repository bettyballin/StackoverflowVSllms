/*
 * Decompiled with CFR 0.152.
 */
public class Main_232 {
    public static void main(String[] stringArray) throws Exception {
        String string = "path_to_your_mde_file.mde";
        Database database = DatabaseBuilder.open(string);
        database.setReadOnly(false);
        database.setEnableEncryption(false);
        Table table = database.getTable("tbl_mytable");
        for (Row row : table.getRows()) {
            System.out.println(row);
        }
    }
}
