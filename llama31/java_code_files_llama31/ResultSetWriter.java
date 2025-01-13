/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ResultSetWriter {
    public static void writeSortedResultSetToFile(ResultSet resultSet, String string) throws SQLException, IOException {
        String[] stringArray;
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        while (resultSet.next()) {
            stringArray = new String[]{resultSet.getString(1), resultSet.getString(2)};
            arrayList.add(stringArray);
        }
        Collections.sort(arrayList, new Comparator<String[]>(){

            @Override
            public int compare(String[] stringArray, String[] stringArray2) {
                return stringArray[0].compareTo(stringArray2[0]);
            }
        });
        stringArray = new PrintWriter(new FileWriter(string));
        try {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                String[] stringArray2;
                for (String string2 : stringArray2 = (String[])iterator.next()) {
                    stringArray.print(string2 + "\t");
                }
                stringArray.println();
            }
        }
        finally {
            stringArray.close();
        }
    }

    public static void main(String[] stringArray) {
    }
}
