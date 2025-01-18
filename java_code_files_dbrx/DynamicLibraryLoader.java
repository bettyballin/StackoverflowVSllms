import java.lang.String;
import java.lang.reflect.Field;
import java.util.Arrays;

public class DynamicLibraryLoader {

    public static void main(String[] args) throws Exception {

        String dllDirectory = "C:/server"; // The absolute directory path where your DLL files reside

        System.setProperty("java.library.path", dllDirectory);

        Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
        fieldSysPath.setAccessible(true);
        String[] sysPathsOld = (String[]) fieldSysPath.get(null);
        String[] sysPathsNew;
        if(sysPathsOld != null) {
            sysPathsNew = Arrays.copyOf(sysPathsOld, sysPathsOld.length + 1);
        } else {
            sysPathsNew = new String[1];
        }
        sysPathsNew[sysPathsNew.length - 1] = dllDirectory;
        fieldSysPath.set(null, sysPathsNew);

        // You can load library here now
        System.loadLibrary("someDLLFile");

    }
}