using System.Net;\nusing System.Net.Security;\nusing System.Security.Cryptography.X509Certificates;\n\n// This method will be called to validate the certificate\nprivate static bool CustomCertificateValidation(\n    object sender, \n    X509Certificate certificate, \n    X509Chain chain, \n    SslPolicyErrors sslPolicyErrors)\n{\n    // Always accept the certificate\n    return true;\n}\n\npublic void InitializeServiceClient()\n{\n    // Set the custom certificate validation callback\n    ServicePointManager.ServerCertificateValidationCallback = CustomCertificateValidation;\n\n    // Your existing setup code\n    BasicHttpBinding binding = new BasicHttpBinding();\n    binding.Security.Mode = BasicHttpSecurityMode.Transport;\n    _ws = new AnnotationService.AnnotationClient(binding, new EndpointAddress(myAddress));\n}