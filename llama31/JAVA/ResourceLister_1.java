import java.lang.String;
import java.lang.Package;
import java.net.URL;
import java.lang.Deprecated;

public class ResourceLister_1_1 {
    public static void listResources(String packageName) {
        Package pkg = Package.getPackage(packageName);
        if (pkg != null) {
            pkg.getAnnotations();
            pkg.getAnnotation(Deprecated.class);
            pkg.getName();
            pkg.getImplementationTitle();
            pkg.getImplementationVendor();
            pkg.getImplementationVersion();
            pkg.getSpecificationTitle();
            pkg.getSpecificationVendor();
            pkg.getSpecificationVersion();
            URL sealBase = pkg.getSealBase();
            if (sealBase != null) {
                System.out.println(sealBase);
            }
        }
    }

    public static void main(String[] args) {
        listResources("com.example.mypackage");
    }
}