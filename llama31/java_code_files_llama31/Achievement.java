/*
 * Decompiled with CFR 0.152.
 */
public class Achievement
extends BaseDomainObject {
    @Embedded
    @AttributeOverride(name="contentID", column=@Column(name="awardedItem"))
    private ContentID awardedItem;

    public static void main(String[] stringArray) {
    }
}
