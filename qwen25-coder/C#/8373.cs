using System;\nusing System.Net.Security;\nusing System.ServiceModel;\n\nclass Program\n{\n    static void Main()\n    {\n        BasicHttpBinding binding = new BasicHttpBinding();\n        binding.Security.Mode = BasicHttpSecurityMode.Transport;\n\n        AnnotationService.AnnotationClient _ws = new AnnotationService.AnnotationClient(binding, new EndpointAddress(myAddress));\n\n        // Disable certificate validation (Use with caution!)\n        _ws.ClientCredentials.ServiceCertificate.SslCertificateAuthentication.Enabled = false;\n        \n        // Alternatively, you can use a custom callback to skip validation\n        // binding.Security.Transport.ClientCredentialType = HttpClientCredentialType.None;\n        // ServicePointManager.ServerCertificateValidationCallback +=\n        //     new RemoteCertificateValidationCallback((sender, certificate, chain, sslPolicyErrors) => true);\n\n        try\n        {\n            _ws.Open();\n            // Call your service methods here...\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Error: " + ex.Message);\n        }\n    }\n}