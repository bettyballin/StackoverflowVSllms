import java.lang.String;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;

public class TrustAllX509TrustManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
        // Do nothing to trust all client certificates
    }

    @Override
    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
        // Do nothing to trust all server certificates
    }

    @Override
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return new java.security.cert.X509Certificate[]{};
    }

	public static void main(String[] args) {
	}
}