import java.lang.String;
public class ClassToTest {
    private final IDisksProvider provider;

    public ClassToTest(IDisksProvider diskProvider) {
        super();
        this.provider = diskProvider;
    }

    public static void main(String[] args) {
    }
}

interface IDisksProvider {
    // Interface methods go here
}