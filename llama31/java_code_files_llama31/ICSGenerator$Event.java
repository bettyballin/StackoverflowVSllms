/*
 * Decompiled with CFR 0.152.
 */
public static class ICSGenerator.Event {
    private String summary;
    private String startDate;
    private String endDate;

    public ICSGenerator.Event(String string, String string2, String string3) {
        this.summary = string;
        this.startDate = string2;
        this.endDate = string3;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }
}
