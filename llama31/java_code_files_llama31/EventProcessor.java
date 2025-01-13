/*
 * Decompiled with CFR 0.152.
 */
public class EventProcessor {
    private DwrServiceOne dwrServiceOne;
    private DwrServiceTwo dwrServiceTwo;

    public EventProcessor(DwrServiceOne dwrServiceOne, DwrServiceTwo dwrServiceTwo) {
        this.dwrServiceOne = dwrServiceOne;
        this.dwrServiceTwo = dwrServiceTwo;
    }

    public void onEvent(Object object) {
        this.dwrServiceOne.remoteCall1();
        this.dwrServiceOne.remoteCall2();
        this.dwrServiceTwo.remoteCall3();
        this.dwrServiceTwo.remoteCall4();
    }

    public static void main(String[] stringArray) {
        DwrServiceOne dwrServiceOne = new DwrServiceOne();
        DwrServiceTwo dwrServiceTwo = new DwrServiceTwo();
        EventProcessor eventProcessor = new EventProcessor(dwrServiceOne, dwrServiceTwo);
        eventProcessor.onEvent(new Object());
    }
}
