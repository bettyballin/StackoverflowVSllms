/*
 * Decompiled with CFR 0.152.
 */
class Service {
    private boolean audit;
    private AuditData auditData;

    Service() {
    }

    public static Service doLookup(String string) {
        return new Service();
    }

    public void setAudit(boolean bl) {
        this.audit = bl;
    }

    public AuditData getAuditData() {
        return new AuditData();
    }
}
