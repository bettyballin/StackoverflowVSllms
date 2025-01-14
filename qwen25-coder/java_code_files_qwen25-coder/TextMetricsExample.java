import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.Structure;

import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinGDI.LOGFONTW;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.WinNT.HANDLE;

import java.util.Arrays;
import java.util.List;

public class TextMetricsExample {

    public static void measureString(String text) {
        // Initialize GDI+
        GDIPlus.GdiplusStartupInput startupInput = new GDIPlus.GdiplusStartupInput();
        startupInput.GdiplusVersion = 1;
        PointerByReference pToken = new PointerByReference();
        int status = GDIPlus.INSTANCE.GdiplusStartup(pToken, startupInput, null);
        if (status != GDIPlus.Ok) {
            System.out.println("Failed to initialize GDI+");
            return;
        }

        // Set up LOGFONT to represent the font you are using
        LOGFONTW logfont = new LOGFONTW();
        logfont.lfHeight = -16; // Negative value for character height in logical units
        logfont.lfFaceName = "Arial"; // Your font name

        PointerByReference fontRef = new PointerByReference();
        // Obtain a handle to the device context (HDC)
        HANDLE hdc = GDI32.INSTANCE.GetDC(null);
        status = GDIPlus.INSTANCE.GdipCreateFontFromLogfontW(hdc, logfont, fontRef);
        if (status != GDIPlus.Ok) {
            System.out.println("Failed to create font");
            GDIPlus.INSTANCE.GdiplusShutdown(pToken.getValue());
            return;
        }

        // Create a Graphics object
        PointerByReference graphicsRef = new PointerByReference();
        status = GDIPlus.INSTANCE.GdipCreateFromHDC(hdc, graphicsRef);
        if (status != GDIPlus.Ok) {
            System.out.println("Failed to create Graphics object");
            GDIPlus.INSTANCE.GdipDeleteFont(fontRef.getValue());
            GDIPlus.INSTANCE.GdiplusShutdown(pToken.getValue());
            return;
        }

        GDIPlus.GpFont font = new GDIPlus.GpFont(fontRef.getValue());
        GDIPlus.GpGraphics graphics = new GDIPlus.GpGraphics(graphicsRef.getValue());

        // Define the layout rectangle
        GDIPlus.GpRectF layoutRect = new GDIPlus.GpRectF();
        layoutRect.X = 0;
        layoutRect.Y = 0;
        layoutRect.Width = Float.MAX_VALUE;
        layoutRect.Height = Float.MAX_VALUE;

        GDIPlus.GpRectF boundingBox = new GDIPlus.GpRectF();

        status = GDIPlus.INSTANCE.GdipMeasureString(graphics, new WString(text), -1, font, layoutRect, null, boundingBox, null, null);
        if (status != GDIPlus.Ok) {
            System.out.println("Failed to measure string");
        } else {
            System.out.println("Width: " + boundingBox.Width + ", Height: " + boundingBox.Height);
        }

        // Clean up
        GDIPlus.INSTANCE.GdipDeleteFont(font.getPointer());
        GDIPlus.INSTANCE.GdipDeleteGraphics(graphics.getPointer());
        GDIPlus.INSTANCE.GdiplusShutdown(pToken.getValue());
        GDI32.INSTANCE.ReleaseDC(null, hdc);
    }

    public static void main(String[] args) {
        measureString("Hello, World!");
    }
}

// GDIPlus interface and supporting classes
interface GDIPlus extends Library {
    GDIPlus INSTANCE = Native.load("GdiPlus", GDIPlus.class);

    public static final int Ok = 0;

    int GdiplusStartup(PointerByReference token, GdiplusStartupInput input, Pointer output);

    void GdiplusShutdown(Pointer token);

    int GdipCreateFontFromLogfontW(HANDLE hdc, LOGFONTW logfont, PointerByReference font);

    int GdipDeleteFont(Pointer font);

    int GdipCreateFromHDC(HANDLE hdc, PointerByReference graphics);

    int GdipDeleteGraphics(Pointer graphics);

    int GdipMeasureString(GpGraphics graphics, WString text, int length, GpFont font, GpRectF layoutRect, Pointer stringFormat, GpRectF boundingBox, Pointer codepointsFitted, Pointer linesFilled);

    // GdiplusStartupInput structure
    public static class GdiplusStartupInput extends Structure {
        public int GdiplusVersion;
        public Pointer DebugEventCallback;
        public boolean SuppressBackgroundThread;
        public boolean SuppressExternalCodecs;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("GdiplusVersion", "DebugEventCallback", "SuppressBackgroundThread", "SuppressExternalCodecs");
        }
    }

    // GpFont class
    public static class GpFont extends PointerType {
        public GpFont() {
            super();
        }
        public GpFont(Pointer address) {
            super(address);
        }
    }

    // GpGraphics class
    public static class GpGraphics extends PointerType {
        public GpGraphics() {
            super();
        }
        public GpGraphics(Pointer address) {
            super(address);
        }
    }

    // GpRectF structure
    public static class GpRectF extends Structure {
        public float X;
        public float Y;
        public float Width;
        public float Height;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("X", "Y", "Width", "Height");
        }
    }
}