public class TestModuleInfo {
    public String getModuleName() {
        return "com.google.gwt.sample.stockwatcher.StockWatcher.JUnit";
    }

    public static void main(String[] args) {
        TestModuleInfo testModuleInfo = new TestModuleInfo();
        System.out.println(testModuleInfo.getModuleName());
    }
}