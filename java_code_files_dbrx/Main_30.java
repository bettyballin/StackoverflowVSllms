public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run(){
                // Your code here which will be executed on its own execution sequence as separate entity from parent thread.
            }
        });
        thread.start();
        // The rest of your original main method continues to execute further in parallel with the newly created thread.
    }
}