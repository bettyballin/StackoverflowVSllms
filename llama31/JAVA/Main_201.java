import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Ole32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinNT.HRESULT;

public class Main_201_201 {
    private static final String SHOCKWAVE_FLASH_PROGID = "ShockwaveFlash.ShockwaveFlash";

    public static void main(String[] args) {
        // Create a new AWT frame
        Frame frame = new Frame("ActiveX Host");
        frame.setBounds(100, 100, 800, 600);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Get the HWND of the AWT frame
        HWND hWnd = new HWND(Native.getComponentPointer(frame));

        // Initialize COM
        Ole32.INSTANCE.CoInitialize(null);

        // Create an instance of the Shockwave Flash ActiveX control
        WinDef.LPVOID pUnk = createActiveXObject(SHOCKWAVE_FLASH_PROGID);

        // Get the IViewObject2 interface from the control
        Pointer pViewObject = getIViewObject2(pUnk);

        // Draw the ActiveX control on the AWT frame's hWnd
        drawActiveXControl(hWnd, pViewObject);

        // Show the AWT frame
        frame.setVisible(true);
    }

    private static WinDef.LPVOID createActiveXObject(String progId) {
        // Create an instance of the ActiveX object using CoCreateInstance
        WinDef.LPVOID pUnk = new WinDef.LPVOID();
        HRESULT hr = Ole32.INSTANCE.CoCreateInstance(
                new WinDef.CLSID(progId),
                null,
                Ole32.CLSCTX.CLSCTX_INPROC_SERVER,
                new WinDef.IID("{00000000-0000-0000-C000-000000000046}"), // IID_IUnknown
                pUnk.getPointer()
        );

        if (FAILED(hr)) {
            System.out.println("Failed to create ActiveX object: " + hr);
            return null;
        }

        return pUnk;
    }

    private static Pointer getIViewObject2(WinDef.LPVOID pUnk) {
        // QueryInterface for IViewObject2
        Pointer pViewObject = new Pointer();
        HRESULT hr = Ole32.INSTANCE.CoQueryInterface(
                pUnk,
                new WinDef.IID("{00000105-0000-0000-C000-000000000046}"), // IID_IViewObject2
                pViewObject.getPointer()
        );

        if (FAILED(hr)) {
            System.out.println("Failed to get IViewObject2: " + hr);
            return null;
        }

        return pViewObject;
    }

    private static void drawActiveXControl(HWND hWnd, Pointer pViewObject) {
        // Get the device context of the AWT frame's hWnd
        WinDef.HDC hdc = User32.INSTANCE.GetDC(hWnd);

        // Get the rectangle of the AWT frame
        RECT rect = new RECT();
        User32.INSTANCE.GetClientRect(hWnd, rect);

        // Draw the ActiveX control on the device context
        HRESULT hr = Ole32.INSTANCE.IViewObject2_Draw(
                pViewObject,
                hdc,
                rect.left,
                rect.top,
                rect.right,
                rect.bottom
        );

        if (FAILED(hr)) {
            System.out.println("Failed to draw ActiveX control: " + hr);
        }

        // Release the device context
        User32.INSTANCE.ReleaseDC(hWnd, hdc);
    }

    private static boolean FAILED(HRESULT hr) {
        return hr.intValue() < 0;
    }
}