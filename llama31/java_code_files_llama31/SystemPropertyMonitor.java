/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class SystemPropertyMonitor {
    public static void main(String[] stringArray) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("java.lang:type=Runtime");
        Object object = mBeanServer.getAttribute(objectName, "SystemProperties");
        while (true) {
            System.out.println(object);
            try {
                Thread.sleep(1000L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                continue;
            }
            break;
        }
    }
}
