import com.android.sdklib.AndroidVersion;
import com.android.sdklib.IAndroidTarget;
import com.android.sdklib.ISdkLog;
import com.android.sdklib.SdkManager;

import java.io.File;

public class SchemaPathFinder {
    public static void main(String[] args) {
        File sdkDir = new File("/path/to/your/android/sdk"); // Update path as necessary
        ISdkLog logger = new ISdkLog() {
            @Override
            public void warning(String warningFormat, Object... args) {
            }

            @Override
            public void error(Throwable t, String errorFormat, Object... args) {
            }

            @Override
            public void printf(String msgFormat, Object... args) {
            }
        };
        SdkManager manager = SdkManager.createManager(sdkDir.getAbsolutePath(), logger);
        for (IAndroidTarget target : manager.getTargets()) {
            if (target.getVersion() != null) { // Target must have a version
                File schemaDir = new File(target.getLocation(), "schemas");
                System.out.println("Schema directory for API level " + target.getVersion().getApiLevel() + ": " + schemaDir.getAbsolutePath());
            }
        }
    }
}