public class CsvPreprocessor {
    public static void main(String[] args) {
        String csv = "foo,bar,n\n,a,bc,d\none,two,three\n,a,bc,d";
        String joinedCsv = csv.replaceAll("\n,", ",");
        System.out.println(joinedCsv);
    }
}