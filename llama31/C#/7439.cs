using System;\nusing System.IO;\nusing System.Net.Http;\nusing System.Threading.Tasks;\n\nclass FileDownloader\n{\n    static async Task Main(string[] args)\n    {\n        string remoteUrl = "https://example.com/datafile.txt";\n        string localPath = @"C:\Downloads\";\n\n        using (var httpClient = new HttpClient())\n        {\n            var response = await httpClient.GetAsync(remoteUrl);\n            if (response.IsSuccessStatusCode)\n            {\n                var fileStream = await response.Content.ReadAsStreamAsync();\n                using (var file = new FileStream(localPath + Path.GetFileName(remoteUrl), FileMode.Create))\n                {\n                    await fileStream.CopyToAsync(file);\n                }\n            }\n            else\n            {\n                Console.WriteLine("Failed to download file");\n            }\n        }\n    }\n}