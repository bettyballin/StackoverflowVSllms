using System;\nusing System.Net;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        using (var client = new WebClient())\n        {\n            try\n            {\n                string responseBody = client.DownloadString("https://api.example.com/data");\n                Console.WriteLine(responseBody);\n            }\n            catch (WebException e)\n            {\n                Console.WriteLine($"Request error: {e.Message}");\n            }\n        }\n    }\n}