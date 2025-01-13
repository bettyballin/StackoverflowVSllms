/*
 * Decompiled with CFR 0.152.
 */
public class GoodService {
    public void createGood(Good good) {
        if (!Validator.isValidCategory((String)good.getCategory())) {
            throw new ValidationException("Invalid category");
        }
    }

    public static void main(String[] stringArray) {
        GoodService goodService = new GoodService();
        Good good = new Good();
        good.setCategory("Valid Category");
        goodService.createGood(good);
    }
}
