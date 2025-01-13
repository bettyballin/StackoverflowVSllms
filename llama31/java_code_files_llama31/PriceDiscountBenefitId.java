/*
 * Decompiled with CFR 0.152.
 */
import java.io.Serializable;

public class PriceDiscountBenefitId
implements Serializable {
    private Integer mapId;
    private Integer planId;

    public Integer getMapId() {
        return this.mapId;
    }

    public void setMapId(Integer n) {
        this.mapId = n;
    }

    public Integer getPlanId() {
        return this.planId;
    }

    public void setPlanId(Integer n) {
        this.planId = n;
    }

    public static void main(String[] stringArray) {
    }
}
