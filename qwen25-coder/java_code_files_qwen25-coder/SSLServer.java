import java.lang.String;
// Example of setting up a simple SSL TCP server in Java
  import javax.net.ServerSocketFactory;
  import javax.net.ssl.SSLServerSocket;
  import java.io.DataInputStream;

  public class SSLServer {
      public static void main(String[] args) throws Exception {
          char[] password = "password".toCharArray();
          javax.net.ssl.KeyManagerFactory kmf =
              javax.net.ssl.KeyManagerFactory.getInstance("SunX509");
          javax.net.ssl.TrustManagerFactory tmf =
              javax.net.ssl.TrustManagerFactory.getInstance("SunX509");

          java.io.FileInputStream fis = new java.io.FileInputStream("keystore.jks");
          java.security.KeyStore ks = java.security.KeyStore.getInstance("JKS");
          ks.load(fis, password);
          fis.close();

          kmf.init(ks, password);
          ks.load(new java.io.FileInputStream("truststore.jks"), password);
          tmf.init(ks);

          javax.net.ssl.SSLContext sc =
              javax.net.ssl.SSLContext.getInstance("TLS");
          sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(),
                  new java.security.SecureRandom());
          ServerSocketFactory ssf = sc.getServerSocketFactory();

          SSLServerSocket sslServerSocket = (SSLServerSocket)ssf.createServerSocket(8443);

          while (true) {
              javax.net.ssl.SSLSocket sslSocket =
                  (javax.net.ssl.SSLSocket)sslServerSocket.accept();
              DataInputStream inputStream = new DataInputStream(sslSocket.getInputStream());
              System.out.println("Received message: " + inputStream.readUTF());
              sslSocket.close();
          }
      }
  }
