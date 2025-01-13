import java.lang.String;

public class EventProcessor {
    // Assuming dwrServiceOne and dwrServiceTwo are instances of some class
    private DwrServiceOne dwrServiceOne;
    private DwrServiceTwo dwrServiceTwo;

    public EventProcessor(DwrServiceOne dwrServiceOne, DwrServiceTwo dwrServiceTwo) {
        this.dwrServiceOne = dwrServiceOne;
        this.dwrServiceTwo = dwrServiceTwo;
    }

    public void onEvent(Object event) {
        dwrServiceOne.remoteCall1();
        dwrServiceOne.remoteCall2();
        dwrServiceTwo.remoteCall3();
        dwrServiceTwo.remoteCall4();
    }

    public static void main(String[] args) {
        // You need to create instances of DwrServiceOne and DwrServiceTwo
        // and pass them to the EventProcessor constructor
        DwrServiceOne dwrServiceOne = new DwrServiceOne();
        DwrServiceTwo dwrServiceTwo = new DwrServiceTwo();
        EventProcessor eventProcessor = new EventProcessor(dwrServiceOne, dwrServiceTwo);
        // You can now call the onEvent method
        eventProcessor.onEvent(new Object());
    }
}

// Assuming DwrServiceOne and DwrServiceTwo are classes with remoteCall methods
class DwrServiceOne {
    public void remoteCall1() {}
    public void remoteCall2() {}
}

class DwrServiceTwo {
    public void remoteCall3() {}
    public void remoteCall4() {}
}