/*
 * Decompiled with CFR 0.152.
 */
public class Deal {
    private Long id;
    private DealType type;

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public DealType getType() {
        return this.type;
    }

    public void setType(DealType dealType) {
        this.type = dealType;
    }

    public static void main(String[] stringArray) {
        Deal deal = new Deal();
        deal.setId(1L);
        deal.setType(DealType.TYPE1);
        System.out.println("Deal ID: " + deal.getId());
        System.out.println("Deal Type: " + String.valueOf((Object)deal.getType()));
    }

    public static enum DealType {
        TYPE1,
        TYPE2;

    }
}
