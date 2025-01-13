using System;\nusing System.Net.Http;\nusing System.Text.RegularExpressions;\nusing System.Threading.Tasks;\n\npublic class Program\n{\n    public static async Task Main()\n    {\n        // URL to load\n        string url = "https://example.com";\n\n        // Load the URL as a string\n        string html = await LoadUrl(url);\n\n        // Regular expression pattern to match\n        string pattern = @"<a href=""([^""]+)"">";\n\n        // Find matches\n        MatchCollection matches = Regex.Matches(html, pattern);\n\n        // Write out matches\n        foreach (Match match in matches)\n        {\n            Console.WriteLine(match.Groups[1].Value);\n        }\n    }\n\n    private static async Task<string> LoadUrl(string url)\n    {\n        using (HttpClient client = new HttpClient())\n        {\n            HttpResponseMessage response = await client.GetAsync(url);\n            response.EnsureSuccessStatusCode();\n            return await response.Content.ReadAsStringAsync();\n        }\n    }\n}