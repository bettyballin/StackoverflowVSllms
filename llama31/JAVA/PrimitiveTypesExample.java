import java.lang.String;

public class PrimitiveTypesExample {
    int i = 12; // decimal literal
    long l = 12L; // long literal
    float f = 12.0F; // float literal
    double d = 12.0D; // double literal
    byte b = (byte) 12; // no byte literal, requires explicit casting
    short s = (short) 12; // no short literal, requires explicit casting

    public static void main(String[] args) {
        PrimitiveTypesExample example = new PrimitiveTypesExample();
        System.out.println("int: " + example.i);
        System.out.println("long: " + example.l);
        System.out.println("float: " + example.f);
        System.out.println("double: " + example.d);
        System.out.println("byte: " + example.b);
        System.out.println("short: " + example.s);
    }
}