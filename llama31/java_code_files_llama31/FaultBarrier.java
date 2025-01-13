/*
 * Decompiled with CFR 0.152.
 */
interface FaultBarrier {
    public static void handleFault(RunnableWithException runnableWithException) {
        try {
            runnableWithException.run();
        }
        catch (Exception exception) {
            System.out.println("Caught exception: " + exception.getMessage());
        }
    }

    @FunctionalInterface
    public static interface RunnableWithException {
        public void run() throws Exception;
    }
}
