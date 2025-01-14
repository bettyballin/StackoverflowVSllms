import org.owasp.encoder.Encode;

public class MyClass {
    String untrustedInput;
    String safeData = Encode.forJavaScript(untrustedInput);
}