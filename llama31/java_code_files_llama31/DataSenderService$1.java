/*
 * Decompiled with CFR 0.152.
 */
class DataSenderService.1
implements Runnable {
    DataSenderService.1() {
    }

    @Override
    public void run() {
        while (DataSenderService.this.sendDataThreadRunning) {
            DataSenderService.this.doSendData();
        }
    }
}
