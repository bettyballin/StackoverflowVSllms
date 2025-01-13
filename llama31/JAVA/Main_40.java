import java.io.*;

public class Main_40 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String line;
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        FileReader fileReader1 = new FileReader(file1);
        FileWriter fileWriter2 = new FileWriter(file2, true); 
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2); 

        while ((line = bufferedReader1.readLine()) != null) {
            if (!line.contains("search_string") || line.contains("another_search_string")) {
                continue;
            }
            bufferedWriter2.write(line);
            bufferedWriter2.newLine(); 
        }

        bufferedReader1.close();
        bufferedWriter2.close(); 
        fileReader1.close();
        fileWriter2.close();
    }
}