/*
 * Decompiled with CFR 0.152.
 */
public class EdiData {
    public static void main(String[] stringArray) {
        String string = "ISA*00*          *00*          *ZZ*SENDER   *01*123456789*ZZ*RECEIVER *010101*0001*U*00401*000000001*0*T*>\nGS*IN*SENDER    *123456789*20230301*0001*X*004010\nST*850*0001\nBEG*00*NE*123456789**AP*20230301*001\nREF*DP*123456789\nN1*ST*JOHN DOE*92 MAIN ST*NEW YORK*NY*10001\nN3*123 ANY ST\nN4*ANYTOWN*CA*12345";
        System.out.println(string);
    }
}
