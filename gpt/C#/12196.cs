using System;\nusing System.IO;\nusing System.Net;\n\nclass Program\n{\n    static void Main()\n    {\n        string url = "https://example.com/file.zip"; // URL of the file to download\n        string destinationPath = @"C:\path\to\save\file.zip"; // Path to save the downloaded file\n\n        using (WebClient client = new WebClient())\n        {\n            try\n            {\n                // Download the file\n                client.DownloadFile(url, destinationPath);\n                Console.WriteLine("File downloaded successfully.");\n            }\n            catch (WebException ex)\n            {\n                Console.WriteLine("An error occurred while downloading the file: " + ex.Message);\n            }\n        }\n    }\n}