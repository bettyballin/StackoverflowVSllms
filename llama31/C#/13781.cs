using System.Net.Http;\nusing System.Threading.Tasks;\n\npublic async Task<ActionResult> ReadExternalFile()\n{\n    string url = "http://example.com/Members/newsletters/welcome.html";\n    using (var client = new HttpClient())\n    {\n        var response = await client.GetAsync(url);\n        if (response.IsSuccessStatusCode)\n        {\n            string fileContents = await response.Content.ReadAsStringAsync();\n            // Do something with the file contents\n            return PartialView(fileContents);\n        }\n        else\n        {\n            // Handle error\n            return PartialView("Error");\n        }\n    }\n}