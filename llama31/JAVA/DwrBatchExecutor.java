import java.lang.String;

public class DwrBatchExecutor {
    public static void main(String[] args) {
        DwrBatchExecutor executor = new DwrBatchExecutor();
        executor.executeBatch();
    }

    public void executeBatch() {
        dwr.engine.beginBatch();
        dwrServiceOne.remoteCall1();
        dwrServiceOne.remoteCall2();
        dwrServiceTwo.remoteCall3();
        dwrServiceTwo.remoteCall4();
        dwr.engine.endBatch();
    }
}