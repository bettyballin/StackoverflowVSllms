import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.platform.win32.WinReg.HKEYByReference;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.WinNT;

public class RegistryWriter {
    public static void setRegistryValue(String name, String value) throws Exception {
        // Using Windows registry in Java requires the use of certain WinRegistry classes and methods since they're not available by default.
        // Here we are setting a string to HKEY_CURRENT_USER.

        HKEYByReference hKey = new HKEYByReference();
        int rc = Advapi32.INSTANCE.RegOpenKeyEx(WinReg.HKEY_CURRENT_USER, "", 0, WinNT.KEY_WRITE, hKey);
        if (rc != WinNT.ERROR_SUCCESS) {
            throw new Exception("Failed to open registry key. Error code: " + rc);
        }

        try {
            rc = Advapi32.INSTANCE.RegSetValueEx(hKey.getValue(), name, 0, WinNT.REG_SZ, value.getBytes("UTF-16LE"), (value.length() + 1) * 2);
            if (rc != WinNT.ERROR_SUCCESS) {
                throw new Exception("Failed to write registry entry. Error code: " + rc);
            }
        } finally {
            Advapi32.INSTANCE.RegCloseKey(hKey.getValue());
        }
    }

    public static void main(String[] args) {
        try {
            setRegistryValue("TestValueName", "TestValueData");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}