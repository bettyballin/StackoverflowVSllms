/*
 * Decompiled with CFR 0.152.
 */
final class EnumMyEnum
extends Enum<EnumMyEnum> {
    private static final /* synthetic */ EnumMyEnum[] $VALUES;

    public static EnumMyEnum[] values() {
        return (EnumMyEnum[])$VALUES.clone();
    }

    public static EnumMyEnum valueOf(String string) {
        return Enum.valueOf(EnumMyEnum.class, string);
    }

    private static /* synthetic */ EnumMyEnum[] $values() {
        return new EnumMyEnum[0];
    }

    static {
        $VALUES = EnumMyEnum.$values();
    }
}
