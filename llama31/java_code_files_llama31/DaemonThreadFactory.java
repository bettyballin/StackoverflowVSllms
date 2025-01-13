/*
 * Decompiled with CFR 0.152.
 */
public class DaemonThreadFactory {
    public static void main(String[] stringArray) {
        ThreadFactory threadFactory = new ThreadFactory(){

            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                return thread;
            }
        };
        final String string = "your_command_here";
        Thread thread = threadFactory.newThread(new Runnable(){

            @Override
            public void run() {
                try {
                    final Process process = Runtime.getRuntime().exec(string);
                    Runtime.getRuntime().addShutdownHook(new Thread(this){

                        @Override
                        public void run() {
                            process.destroy();
                        }
                    });
                }
                catch (Exception exception) {
                    System.err.println("Error executing command: " + exception.getMessage());
                }
            }
        });
        thread.start();
    }
}
