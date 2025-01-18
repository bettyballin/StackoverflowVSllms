import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CpuUsage {

    public static void main(String[] args) {
        String cpuUsageCmd = "mpstat | awk '{print $12}' "; // This is specific to Linux/Unix. You'd need a different command for Windows.
        Process processCPU_USAGE;
        BufferedReader bufferedReaderCPU;
        float CPU;
        try {
            processCPU_USAGE = Runtime.getRuntime().exec(cpuUsageCmd);
            bufferedReaderCPU = new BufferedReader(new InputStreamReader(processCPU_USAGE.getInputStream()));
            String cpuValue;
            while ((cpuValue = bufferedReaderCPU.readLine()) != null) {
                CPU = Float.valueOf(cpuValue) / 100;
                System.out.println("Used/Free CPU : " + CPU);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}