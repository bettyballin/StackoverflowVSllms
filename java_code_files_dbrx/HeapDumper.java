import com.sun.management.HotSpotDiagnosticMXBean;
import java.lang.management.ManagementFactory;

public class HeapDumper {
    public static void main(String[] args) throws Exception {
        HotSpotDiagnosticMXBean hprof = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
        hprof.dumpHeap("filename", true); // writes a binary format dump to the specified file where second argument is for live mode (true means only live objects are written)
    }
}