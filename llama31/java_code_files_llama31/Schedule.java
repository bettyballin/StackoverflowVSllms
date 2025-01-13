/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;

public class Schedule {
    private int locationNum;
    private int cost;
    private String costReason;
    private Date weekOfChange;
    private Date dayOfChange;
    private String changeReason;

    public Schedule(int n, int n2, String string, Date date, Date date2, String string2) {
        this.locationNum = n;
        this.cost = n2;
        this.costReason = string;
        this.weekOfChange = date;
        this.dayOfChange = date2;
        this.changeReason = string2;
        if (!(date != null && date2 != null && string2 != null || date == null && date2 == null && string2 == null)) {
            throw new ApplicationException();
        }
    }

    public int getLocationNum() {
        return this.locationNum;
    }

    public void setLocationNum(int n) {
        this.locationNum = n;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int n) {
        this.cost = n;
    }

    public String getCostReason() {
        return this.costReason;
    }

    public void setCostReason(String string) {
        this.costReason = string;
    }

    public Date getWeekOfChange() {
        return this.weekOfChange;
    }

    public void setWeekOfChange(Date date) {
        this.weekOfChange = date;
    }

    public Date getDayOfChange() {
        return this.dayOfChange;
    }

    public void setDayOfChange(Date date) {
        this.dayOfChange = date;
    }

    public String getChangeReason() {
        return this.changeReason;
    }

    public void setChangeReason(String string) {
        this.changeReason = string;
    }
}
