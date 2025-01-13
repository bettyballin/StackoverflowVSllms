/*
 * Decompiled with CFR 0.152.
 */
public class AuditServiceManager {
    public static void main(String[] stringArray) {
        Service service = Service.doLookup("myService");
        service.setAudit(true);
        AuditData auditData = service.getAuditData();
        long l = auditData.getExecutionTime();
        long l2 = auditData.getMemoryUsed();
        System.out.println("Execution Time: " + l);
        System.out.println("Memory Used: " + l2);
    }
}
