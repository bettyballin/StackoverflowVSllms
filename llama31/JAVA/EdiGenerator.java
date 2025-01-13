public class EdiGenerator {
    public static void main(String[] args) {
        String isa = "ISA*00*          *00*          *ZZ*SENDER   *01*123456789*ZZ*RECEIVER *010101*0001*U*00401*000000001*0*T*>";
        String gs = "GS*IN*SENDER    *123456789*20230301*0001*X*004010";
        String st = "ST*850*0001";
        String beg = "BEG*00*NE*123456789**AP*20230301*001";
        String ref = "REF*DP*123456789";
        String n1 = "N1*ST*JOHN DOE*92 MAIN ST*NEW YORK*NY*10001";
        String n3 = "N3*123 ANY ST";
        String n4 = "N4*ANYTOWN*CA*12345";

        System.out.println(isa);
        System.out.println(gs);
        System.out.println(st);
        System.out.println(beg);
        System.out.println(ref);
        System.out.println(n1);
        System.out.println(n3);
        System.out.println(n4);
    }
}