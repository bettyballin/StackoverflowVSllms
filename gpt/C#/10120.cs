using System;\nusing System.Net;\n\nclass Program\n{\n    static void Main()\n    {\n        // Enable default proxy and use default credentials\n        WebRequest.DefaultWebProxy = WebRequest.GetSystemWebProxy();\n        WebRequest.DefaultWebProxy.Credentials = CredentialCache.DefaultCredentials;\n\n        // Example of creating a WCF client and using the configured proxy settings\n        // Assuming you have a WCF client named MyWcfClient\n        // MyWcfClient client = new MyWcfClient();\n        // client.ClientCredentials.Windows.ClientCredential = CredentialCache.DefaultNetworkCredentials;\n\n        Console.WriteLine("Default proxy and credentials configured successfully.");\n    }\n}