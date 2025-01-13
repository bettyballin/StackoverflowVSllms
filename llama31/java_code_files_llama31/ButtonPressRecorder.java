/*
 * Decompiled with CFR 0.152.
 */
public class ButtonPressRecorder {
    long[] buttonPressTimes = new long[100];
    int index = 0;

    public void recordButtonPress() {
        this.buttonPressTimes[this.index] = System.currentTimeMillis();
        ++this.index;
    }

    public static void main(String[] stringArray) {
        ButtonPressRecorder buttonPressRecorder = new ButtonPressRecorder();
        buttonPressRecorder.recordButtonPress();
    }
}
