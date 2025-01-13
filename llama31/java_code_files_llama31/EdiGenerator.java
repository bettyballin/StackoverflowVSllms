/*
 * Decompiled with CFR 0.152.
 */
public class EdiGenerator {
    public static void main(String[] stringArray) {
        String string = "ISA*00*          *00*          *ZZ*SENDER   *01*123456789*ZZ*RECEIVER *010101*0001*U*00401*000000001*0*T*>";
        String string2 = "GS*IN*SENDER    *123456789*20230301*0001*X*004010";
        String string3 = "ST*850*0001";
        String string4 = "BEG*00*NE*123456789**AP*20230301*001";
        String string5 = "REF*DP*123456789";
        String string6 = "N1*ST*JOHN DOE*92 MAIN ST*NEW YORK*NY*10001";
        String string7 = "N3*123 ANY ST";
        String string8 = "N4*ANYTOWN*CA*12345";
        System.out.println(string);
        System.out.println(string2);
        System.out.println(string3);
        System.out.println(string4);
        System.out.println(string5);
        System.out.println(string6);
        System.out.println(string7);
        System.out.println(string8);
    }
}
