public class EdiData {
    public static void main(String[] args) {
        String ediData = "ISA*00*          *00*          *ZZ*SENDER   *01*123456789*ZZ*RECEIVER *010101*0001*U*00401*000000001*0*T*>\n" +
                         "GS*IN*SENDER    *123456789*20230301*0001*X*004010\n" +
                         "ST*850*0001\n" +
                         "BEG*00*NE*123456789**AP*20230301*001\n" +
                         "REF*DP*123456789\n" +
                         "N1*ST*JOHN DOE*92 MAIN ST*NEW YORK*NY*10001\n" +
                         "N3*123 ANY ST\n" +
                         "N4*ANYTOWN*CA*12345";

        System.out.println(ediData);
    }
}