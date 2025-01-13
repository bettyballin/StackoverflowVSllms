using System;\nusing System.IO;\nusing System.Net;\n\npublic class FileDownloader\n{\n    public static void DownloadFile(string url, string path)\n    {\n        int retries = 3;\n        int delay = 500; // ms\n\n        for (int i = 1; i <= retries; i++)\n        {\n            try\n            {\n                using (var client = new WebClient())\n                {\n                    client.DownloadFile(url, path);\n                }\n                break; // Success, exit loop\n            }\n            catch (WebException ex) when (i < retries)\n            {\n                Console.WriteLine($"Attempt {i} failed: {ex.Message}. Retrying...");\n                System.Threading.Thread.Sleep(delay);\n            }\n        }\n    }\n\n    public static void Main(string[] args)\n    {\n        DownloadFile("http://example.com/largefile.zip", @"C:\Downloads\largefile.zip");\n    }\n}