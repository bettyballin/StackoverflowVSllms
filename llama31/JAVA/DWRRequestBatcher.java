import java.lang.String;

public class DWRRequestBatcher {
    public static void main(String[] args) {
        dwr.engine.beginBatch();
        dwrServiceOne.remoteCall1();
        dwrServiceOne.remoteCall2();
        dwrServiceTwo.remoteCall3();
        dwrServiceTwo.remoteCall4();
        dwr.engine.endBatch();
    }
}