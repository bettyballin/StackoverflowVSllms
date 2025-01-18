import java.util.List;
import java.util.ArrayList;
public class HeapMonitor {
    public static void main(String[] args) throws Exception{
        List<RuntimeData> runtimeDatas = new ArrayList<RuntimeData>();
        while (true){
            Thread.sleep(500); // sleep for 500ms before fetching the data again to prevent spike in CPU usage
            Runtime runtime = Runtime.getRuntime();
            long usedHeap = runtime.totalMemory() - runtime.freeMemory();
            long totalHeap = runtime.totalMemory();
            double freeHeapToTotalHeapRatio = (double) runtime.freeMemory() / totalHeap;
            System.out.println("Used Heap: " + usedHeap + " bytes \t Total Heap:"+ totalHeap +" bytes \t Free to Total Ratio :"+freeHeapToTotalHeapRatio);
            runtimeDatas.add(new RuntimeData((double)usedHeap,(double)totalHeap, freeHeapToTotalHeapRatio));
        }
    }
     static class RuntimeData {
         final double usedHeap;
         final double totalHeap;
         final double ratio;

          public RuntimeData(double usedHeap, double totalHeap, double ratio) {
              this.usedHeap = usedHeap;
              this.totalHeap = totalHeap;
              this.ratio = ratio;
            }
        @Override
        public String toString() {
           return "{\n" 
                   + "\t\"Used Heap\":\"" + this.usedHeap + "\", \t" 
                   + "\t\"Total Heap\":\"" + this.totalHeap + "\", \t"
                   + "\t\"Free To Total Ratio\" : " + this.ratio 
                   + "}";
        }
    } 
}