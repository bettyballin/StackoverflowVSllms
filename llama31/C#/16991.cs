// Silverlight Client (C#)\nusing System;\nusing System.Windows;\nusing System.Windows.Media;\n\nnamespace VideoPlayer\n{\n    public partial class MainPage : UserControl\n    {\n        public MainPage()\n        {\n            InitializeComponent();\n            MediaElement mediaElement = new MediaElement();\n            mediaElement.Source = new Uri("http://your-server/your-video.wmv");\n            mediaElement.Play();\n        }\n    }\n}\n\n// PlayReady Server (C#)\nusing System;\nusing System.Net;\nusing Microsoft.PlayReady;\n\nnamespace PlayReadyServer\n{\n    public class LicenseIssuer\n    {\n        public LicenseIssuer()\n        {\n            // Initialize PlayReady Server\n            PlayReadyServer server = new PlayReadyServer();\n            server.Initialize();\n        }\n\n        public void IssueLicense(HttpRequest request)\n        {\n            // Authenticate client (e.g., check IP address)\n            if (request.UserHostAddress.StartsWith("192.168.1."))\n            {\n                // Issue license\n                PlayReadyLicense license = new PlayReadyLicense();\n                license.IssueDate = DateTime.Now;\n                license.ExpirationDate = DateTime.Now.AddHours(1);\n                server.IssueLicense(license, request);\n            }\n            else\n            {\n                // Deny license request\n                server.DenyLicenseRequest(request);\n            }\n        }\n    }\n}