/*
 * Decompiled with CFR 0.152.
 */
public class ItemQuery {
    String query = "SELECT color, pattern, size, manufacturer, mfgSku, storeLocation, aisle, status FROM tblItems WHERE ourSku = ?";

    public static void main(String[] stringArray) {
        ItemQuery itemQuery = new ItemQuery();
    }
}
