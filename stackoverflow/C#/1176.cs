private SslStream WrapSocket(Socket socket)\n{\n  var myNetworkStream = new NetworkStream(socket);\n  var mySslStream = new SslStream(myNetworkStream, false, OnCertificateValidation);\n  mySslStream.AuthenticateAsClient(String.Empty);\n}\n\nprivate static bool OnCertificateValidation (object sender, X509Certificate certificate, X509Chain chain, SslPolicyErrors sslPolicyErrors)\n{\n  return true; // NOT RECOMMENDED FOR PRODUCTION CODE\n}