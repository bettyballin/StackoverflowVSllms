/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

class ViewState
implements Serializable {
    private String data;

    ViewState() {
    }

    public void setData(String string) {
        this.data = string;
    }

    public String getData() {
        return this.data;
    }
}
