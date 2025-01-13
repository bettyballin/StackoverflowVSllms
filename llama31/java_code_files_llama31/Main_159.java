/*
 * Decompiled with CFR 0.152.
 */
public class Main_159 {
    public static void main(String[] stringArray) {
        int n = 0xA00000;
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setAttribute("maxPostSize", n);
        System.out.println("Attribute set successfully.");
    }
}
