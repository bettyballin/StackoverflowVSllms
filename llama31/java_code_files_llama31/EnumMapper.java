/*
 * Decompiled with CFR 0.152.
 */
public class EnumMapper {
    public static void main(String[] stringArray) {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.mapValue();
    }

    public void mapValue() {
        String string;
        System.out.println(switch (string = "Y") {
            case "Y" -> "Yes";
            case "N" -> "No";
            default -> "Unknown";
        });
    }
}
