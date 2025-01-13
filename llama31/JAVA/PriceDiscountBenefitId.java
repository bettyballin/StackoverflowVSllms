import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class PriceDiscountBenefitId implements Serializable {
    private Integer mapId;
    private Integer planId;

    // getters and setters
    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public static void main(String[] args) {
    }
}