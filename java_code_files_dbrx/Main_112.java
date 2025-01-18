public class Main {
    public static void main(String[] args) throws Exception {
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(new String[]{"echo", "hello", "world"});
        pr.waitFor(); // wait for the command to finish
    }
}