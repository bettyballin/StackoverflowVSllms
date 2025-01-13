/*
 * Decompiled with CFR 0.152.
 */
class LicenseData {
    private String version;
    private int duration;
    private String userName;

    LicenseData() {
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String string) {
        this.version = string;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int n) {
        this.duration = n;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String string) {
        this.userName = string;
    }

    public byte[] toByteArray() {
        String string = this.version + "," + this.duration + "," + this.userName;
        return string.getBytes();
    }
}
