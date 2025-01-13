/*
 * Decompiled with CFR 0.152.
 */
static class DaemonThreadFactory.2
implements Runnable {
    final /* synthetic */ String val$command;

    DaemonThreadFactory.2(String string) {
        this.val$command = string;
    }

    @Override
    public void run() {
        try {
            final Process process = Runtime.getRuntime().exec(this.val$command);
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
}
