import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;

public class CpuLoad {
    public static void main(String[] args) throws Exception {
        Sigar sigar = new Sigar();
        CpuPerc cpu = sigar.getCpuPerc();
        System.out.println("CPU load is " + String.format("%.2f", (cpu.getCombined() * 100)));
    }
}