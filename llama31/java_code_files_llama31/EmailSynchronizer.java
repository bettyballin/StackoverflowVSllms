/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EmailSynchronizer {
    public static void main(String[] stringArray) {
        String string = "exampleUser";
        Form form = new Form();
        DB dB = new DB();
        List<String> list = EmailSynchronizer.getAllMailsFromDB(string);
        List<String> list2 = form.getAllMails();
        HashSet<String> hashSet = new HashSet<String>(list2);
        for (String string2 : list) {
            if (hashSet.contains(string2)) continue;
            dB.deleteMail(string2);
        }
        for (String string2 : list2) {
            if (list.contains(string2)) continue;
            dB.insertMail(string2, string);
        }
    }

    public static List<String> getAllMailsFromDB(String string) {
        return new ArrayList<String>();
    }
}
