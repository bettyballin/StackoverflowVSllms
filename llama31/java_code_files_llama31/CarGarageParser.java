/*
 * Decompiled with CFR 0.152.
 */
public class CarGarageParser {
    public static void main(String[] stringArray) {
        CarGarage carGarage = new CarGarage();
        String string = "<carGarage><car><make>Chrysler</make><color>Red</color></car><car><make>Musano</make><color>Blue</color></car></carGarage>";
        carGarage.DOMparsingMethod(string);
    }
}
